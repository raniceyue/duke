package duke.exceptions;

import java.nio.file.Path;

public class DukeBadPathException extends DukeException {
    public DukeBadPathException(Path path) {
        super.message = "The path " + path + " does not exist!";
    }
}
