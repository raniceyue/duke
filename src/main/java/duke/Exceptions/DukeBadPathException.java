package duke.Exceptions;

import java.nio.file.Path;

/**
 * Exception to handle event where path to data file does not exist.
 */
public class DukeBadPathException extends DukeException {
    public DukeBadPathException(Path path) {
        super.message = "The path " + path + " does not exist!";
    }
}
