package duke.util;

import duke.Commands.*;
import duke.Exceptions.*;
import duke.Tasks.Deadline;
import duke.Tasks.Event;
import duke.Tasks.Task;
import duke.Tasks.ToDo;
import java.util.Scanner;

public class Parser {
    protected String command;

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
        Task t;
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
                throw new DukeBadFileException();
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
}
