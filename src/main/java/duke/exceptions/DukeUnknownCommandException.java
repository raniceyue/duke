package duke.exceptions;

/**
 * Exception to handle unexpected input.
 */
public class DukeUnknownCommandException extends DukeException {
    public DukeUnknownCommandException() {
        super.message = "What the hell are you saying?? I don't get you...";
    }
}
