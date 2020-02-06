package duke.exceptions;

/**
 * Exception to handle event where command is missing date input.
 */
public class DukeNoDateException extends DukeException {
    /**
     * Method to customise exception message.
     * @param taskName name of task with missing date.
     */
    public DukeNoDateException(String taskName) {
        if (taskName.equals("deadline")) {
            super.message = "Doesn't a deadline have a date?? Aren't you forgetting something??";
        } else {
            super.message = "When is this even supposed to happen? You forgot the date!";
        }
    }
}