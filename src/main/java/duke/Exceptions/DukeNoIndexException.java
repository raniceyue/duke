package duke.Exceptions;

public class DukeNoIndexException extends DukeException {
    public DukeNoIndexException(String command) {
        if (command.equals("delete")) {
            super.message = "You forgot to tell me what to delete!";
        } else {
            super.message = "You forgot to tell me what to mark as done!!";
        }
    }
}
