package duke.Exceptions;

/**
 * Exception to handle when text in data file is not formatted correctly.
 */
public class DukeBadFileException extends DukeException {
    public DukeBadFileException() {
        super.message = "The file you are trying to load is not in the correct format!!";
    }
}
