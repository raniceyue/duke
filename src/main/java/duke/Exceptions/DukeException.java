package duke.Exceptions;

import duke.util.Ui;

public class DukeException extends Exception {
    protected String message;

    @Override
    public String toString() {
        String output = Ui.setBorder(message);
        return output;
    }
}
