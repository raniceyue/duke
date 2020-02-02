package duke.util;

import duke.Commands.*;
import duke.Exceptions.*;
import duke.Tasks.Deadline;
import duke.Tasks.Event;
import duke.Tasks.Task;
import duke.Tasks.ToDo;
import java.util.Scanner;

/**
 * Represents parser that parses commands from the user input.
 * Parser also handles parsing of data from storage file, to be loaded into the program.
 */
public class Parser {
    protected String command;

    /**
     * Method that parses single line of command.
     * @param s string to be parsed.
     * @return parsed command as a command object.
     * @throws DukeException if the command is invalid, not formatted correctly or is missing information.
     */
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
                        isValidDateTime(details[1]);
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
                        isValidDateTime(details[1]);
                        return new DeadlineCommand(details[0], details[1]);
                    }
                }
            default:
                throw new DukeUnknownCommandException();
        }
    }

    /**
     * Method to parse a single line from the storage file.
     * @param e string to be parsed.
     * @return parsed line as a task object.
     * @throws DukeException if the data in the file is not formatted correctly.
     */
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

    /*
    IMPORTANT: parseFileLine incomplete, not all edge cases accounted for.
     */

    /**
     * Method to check if indices are positive integers.
     * @param index to be checked.
     * @throws DukeBadIndexException to handle event where index is not valid.
     */
    public static void isValidIndex(int index) throws DukeBadIndexException {
        if (index == 0 || index < 0) {
            throw new DukeBadIndexException(index);
        }
    }

    /**
     * Method to check if the date and time are formatted correctly.
     * @param dateTime date and time string to be checked.
     * @throws DukeBadDateException if the date is not in the correct format.
     * @throws DukeBadDateTimeException if the date and time are not in the correct format.
     */
    public static void isValidDateTime(String dateTime) throws DukeBadDateException, DukeBadDateTimeException {
        String[] p = dateTime.split(" ");
        if (p.length < 2) {
            throw new DukeBadDateTimeException();
        } else {
            String date = p[0];
            String time = p[1];
            String[] date_parsed = date.split("-");
            if (date_parsed.length < 3) {
                throw new DukeBadDateException();
            }
        }
    }
}
