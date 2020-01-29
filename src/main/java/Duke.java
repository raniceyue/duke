import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {

        String border = "=^..^=   =^..^=   =^..^=    =^..^=    =^..^=    =^..^=    =^..^=\n";
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n\n";
        System.out.println("Greetings mortal, my name is\n" + logo + "How may I help you?\n");

        ArrayList<Task> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        label:
        while (sc.hasNextLine()) {
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
                            StringBuilder outputBuilder = new StringBuilder(border + "\n\tHere is your list:\n");
                            for (Task t : list) {
                                outputBuilder.append("\t(").append(list.indexOf(t) + 1).append(") ").append(t).append("\n");
                            }
                            String output = outputBuilder.toString();
                            output += "\n" + border;
                            System.out.println(output);
                        }
                        break;
                    case "done":
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
                                System.out.println(output);
                            }
                        }
                        break;
                    case "delete":
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
                                System.out.println(output);
                            }
                        }
                        break;
                    default: {
                        String output = border + "\n\t" + "ADDED : ";
                        switch (command) {
                            case "todo": {
                                if (!parse.hasNextLine()) {
                                    throw new DukeNoDescriptionException("todo");
                                }
                                String item = parse.nextLine();
                                list.add(new ToDo(item));
                                break;
                            }
                            case "event": {
                                if (!parse.hasNextLine()) {
                                    throw new DukeNoDescriptionException("event");
                                }
                                String item = parse.nextLine();
                                String[] details = item.split("/at");
                                if (details.length < 2) {
                                    throw new DukeNoDateException(command);
                                }
                                list.add(new Event(details[0], details[1].strip()));
                                break;
                            }
                            case "deadline": {
                                if (!parse.hasNextLine()) {
                                    throw new DukeNoDescriptionException("deadline");
                                }
                                String item = parse.nextLine();
                                String[] details = item.split("/by");
                                if (details.length < 2) {
                                    throw new DukeNoDateException(command);
                                }
                                list.add(new Deadline(details[0], details[1].strip()));
                                break;
                            }
                            default:
                                throw new DukeUnknownCommandException();
                        }
                        output += list.get(list.size() - 1) + "\n" + "\tYou now have " + list.size() + " item(s) on your list." + "\n\n" + border;
                        System.out.println(output);
                        break;
                    }
                }
            } catch (DukeException e) {
                System.out.println(e);
            }
        }
    }
}
