import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;

import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;

public class Duke {
    public static void main(String[] args) {

        String border = "=^..^=   =^..^=   =^..^=    =^..^=    =^..^=    =^..^=    =^..^=\n";
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n\n";
        System.out.println("Greetings mortal, my name is\n" + logo + "How may I help you?\n");

        String home = System.getProperty("user.dir");
        Path project_root = Paths.get(home).getParent().getParent().getParent();
        Path data_path = Paths.get(project_root.toString(),"data", "duke.txt");

        Scanner sc = new Scanner(System.in);

        label:
        while (sc.hasNextLine()) {
            ArrayList<Task> list = new ArrayList<>();
            try {
                List<String> loaded_data = Files.readAllLines(data_path);
                for (String e : loaded_data) {
                    if (loaded_data.size() == 1 && e.isBlank()) {
                        break;
                    }
                    String task_type = e.substring(0, 3);
                    String task_status = e.substring(3, 6);
                    String task_details = e.substring(7);
                    Task t = null;
                    switch (task_type) {
                        case "[T]":
                            t = new ToDo(task_details);
                            break;
                        case "[E]": {
                            String[] details = task_details.split(" /at ");
                            t = new Event(details[0], details[1]);
                            break;
                        }
                        case "[D]": {
                            String[] details = task_details.split(" /by ");
                            t = new Deadline(details[0], details[1]);
                            break;
                        }
                        default:
                            System.out.println("Corrupted Data!!");
                            break;
                    }

                    if (task_status.equals("[X]")) {
                        t.setDone();
                    }
                    list.add(t);
                }
            } catch (IOException e) {
                System.out.println("IOException occurred.");
            }

            String input = sc.nextLine();
            Scanner parse = new Scanner(input);
            String command = parse.next();
            try {
                switch (command) {
                    case "bye": {
                        String output = border + "\n" + "\tSee u the next time you test ur code :P\n\n" + border;
                        System.out.println(output);
                        break label;
                    }
                    case "list":
                        if (list.size() == 0) {
                            String output = border + "\n\tYou have nothing on your list.\n\n" + border;
                            System.out.println(output);
                        } else {
                            StringBuilder output = new StringBuilder(border + "\n\tHere is your list:\n");
                            for (Task t : list) {
                                output.append("\t(").append(list.indexOf(t) + 1).append(") ").append(t).append("\n");
                            }
                            output.append("\n").append(border);
                            System.out.println(output);
                        }
                        break;
                    case "done":     // CHANGE
                        if (!parse.hasNextInt()) {
                            throw new DukeNoIndexException(command);
                        } else {
                            int index = parse.nextInt();
                            if (index > list.size() || index < 0) {
                                throw new DukeBadIndexException(index);
                            } else {
                                list.get(index - 1).setDone();
                                String output = border + "\n\tI've marked (" + index + ") as done!\n"
                                        + "\t(" + index + ") " + list.get(index - 1) + "\n\n" + border;
                                WriteToFile(list, data_path);
                                System.out.println(output);
                            }
                        }
                        break;
                    case "delete":   // CHANGE
                        if (!parse.hasNextInt()) {
                            throw new DukeNoIndexException(command);
                        } else {
                            int index = parse.nextInt();
                            if (index > list.size() || index < 0) {
                                throw new DukeBadIndexException(index);
                            } else {
                                String output = border + "\n\tOK, I've removed the task:\n\t\t" + list.get(index - 1) + "\n"
                                        + "\tYou now have " + (list.size() - 1) + " task(s) on your list.\n\n" + border;
                                list.remove(index - 1);
                                WriteToFile(list, data_path);
                                System.out.println(output);
                            }
                        }
                        break;
                    default: {                                 // CHANGE
                        String output = border + "\n\t" + "ADDED : ";
                        switch (command) {
                            case "todo": {
                                if (!parse.hasNextLine()) {
                                    throw new DukeNoDescriptionException("todo");
                                }
                                String item = parse.nextLine().strip();
                                list.add(new ToDo(item));
                                break;
                            }
                            case "event": {
                                if (!parse.hasNextLine()) {
                                    throw new DukeNoDescriptionException("event");
                                }
                                String item = parse.nextLine().strip();
                                String[] details = item.split(" /at ");
                                if (details.length < 2) {
                                    throw new DukeNoDateException(command);
                                }
                                list.add(new Event(details[0], details[1]));
                                break;
                            }
                            case "deadline": {
                                if (!parse.hasNextLine()) {
                                    throw new DukeNoDescriptionException("deadline");
                                }
                                String item = parse.nextLine().strip();
                                String[] details = item.split(" /by ");
                                if (details.length < 2) {
                                    throw new DukeNoDateException(command);
                                }
                                list.add(new Deadline(details[0], details[1]));
                                break;
                            }
                            default:
                                throw new DukeUnknownCommandException();
                        }
                        output += list.get(list.size() - 1) + "\n" + "\tYou now have " + list.size() + " item(s) on your list." + "\n\n" + border;
                        WriteToFile(list, data_path);
                        System.out.println(output);
                        break;
                    }
                }
            } catch (DukeException e) {
                System.out.println(e);
            }
        }
    }


    public static void WriteToFile(ArrayList<Task> list, Path path) {
        try {
            StringBuilder toWrite = new StringBuilder();
            for (Task e : list) {
                if (e instanceof ToDo) {
                    toWrite.append(e.toString()).append("\n");
                } else if (e instanceof Event) {
                    toWrite.append(((Event) e).WriteFormat()).append("\n");
                } else if (e instanceof Deadline) {
                    toWrite.append(((Deadline) e).WriteFormat()).append("\n");
                }
            }
            FileWriter fw = new FileWriter(path.toFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(toWrite.toString());
            bw.close();
            fw.close();
            System.out.println("Write occurred!!\n");
        } catch (IOException e) {
            System.out.println("IOException occurred.");
        }
    }
}