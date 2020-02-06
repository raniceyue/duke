package duke.exceptions;

import duke.util.Ui;

/**
 * Superclass to generalise exceptions for the duke.Duke program.
 */
public class DukeException extends Exception {
    protected String message;

    @Override
    public String toString() {
        String output = Ui.setBorder(message);
        return output;
    }
}
