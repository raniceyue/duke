package duke.exceptions;

/**
 * Exception to handle indices that are out of range.
 */
public class DukeBadIndexException extends DukeException {
    /**
     * Method to customise exception message.
     * @param index of input.
     */
    public DukeBadIndexException(int index) {
        if (index < 0) {
            super.message = "You can't enter a negative index!!";
        } else {
            super.message = "I don't think you have that many tasks my dude.";
        }
    }
}
