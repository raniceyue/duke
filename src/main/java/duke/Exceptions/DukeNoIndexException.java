package duke.Exceptions;

/**
 * Exception to handle event where commands to manipulate list have no index provided.
 */
public class DukeNoIndexException extends DukeException {
    public DukeNoIndexException(String command) {
        if (command.equals("delete")) {
            super.message = "You forgot to tell me what to delete!";
        } else {
            super.message = "You forgot to tell me what to mark as done!!";
        }
    }
}
