package duke.util;

import duke.Commands.*;
import duke.Exceptions.*;
import duke.Tasks.Deadline;
import duke.Tasks.Event;
import duke.Tasks.Task;
import duke.Tasks.ToDo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Parser {
    protected String command;
    protected String taskName;
    protected String dateTime;
    public static List<String> commandList = new ArrayList<>(List.of("bye", "list", "delete", "done", "event", "deadline", "todo"));

    String border = "=^..^=   =^..^=   =^..^=    =^..^=    =^..^=    =^..^=    =^..^=\n";

    public static Command parseCommand(String s) throws DukeException {
        Scanner sc = new Scanner(s);
        String w1 = sc.next();
        switch (w1) {
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "done":
                if (sc.hasNextInt()) {
                    int index = sc.nextInt();
                    isValidIndex(index);
                    return new DoneCommand(index);
                } else {
                    throw new DukeNoIndexException(w1);
                }
            case "delete":
                if (sc.hasNextInt()) {
                    int index = sc.nextInt();
                    isValidIndex(index);
                    return new DeleteCommand(index);
                } else {
                    throw new DukeNoIndexException(w1);
                }
            case "todo":
                if (!sc.hasNextLine()) throw new DukeNoDescriptionException(w1);
                else {
                    return new ToDoCommand(sc.nextLine());
                }
            case "event":
                if (!sc.hasNextLine()) throw new DukeNoDescriptionException(w1);
                else {
                    String task = sc.nextLine().strip();
                    String[] details = task.split(" /at ");
                    if (details.length < 2) {
                        throw new DukeNoDateException(w1);
                    } else {
                        return new EventCommand(details[0], details[1]);
                    }
                }
            case "deadline":
                if (!sc.hasNextLine()) throw new DukeNoDescriptionException(w1);
                else {
                    String task = sc.nextLine().strip();
                    String[] details = task.split(" /by ");
                    if (details.length < 2) {
                        throw new DukeNoDateException(w1);
                    } else {
                        return new DeadlineCommand(details[0], details[1]);
                    }
                }
            default:
                throw new DukeUnknownCommandException();
        }
    }

    public static Task parseFileLine(String e) throws DukeException {
        String task_type = e.substring(0, 3);
        String task_status = e.substring(3, 6);
        String task_details = e.substring(7);
        Task t = null;
        if (task_type.equals("[T]")) {
            t = new ToDo(task_details);
        } else if (task_type.equals("[E]")) {
            String[] details = task_details.split(" /at ");
            t = new Event(details[0], details[1]);
        } else if (task_type.equals("[D]")) {
            String[] details = task_details.split(" /by ");
            t = new Deadline(details[0], details[1]);
        } else {
            throw new DukeNoDateException("testtttttt");
        }
        if (task_status.equals("[X]")) {
            t.setDone();
        }
        return t;
    }


    public static void isValidIndex(int index) throws DukeBadIndexException {
        if (index == 0 || index < 0) {
            throw new DukeBadIndexException(index);
        }
    }

    public static boolean isValidCommand(String s) {
        return commandList.contains(s);
    }


}
