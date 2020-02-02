package duke.Exceptions;

import duke.util.Ui;

/**
 * Superclass to generalise exceptions for the Duke program.
 */
public class DukeException extends Exception {
    protected String message;

    @Override
    public String toString() {
        String output = Ui.setBorder(message);
        return output;
    }
}
