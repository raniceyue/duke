package duke.exceptions;

public class DukeBadFileException extends DukeException {
    public DukeBadFileException() {
        super.message = "The file you are trying to load is not in the correct format!!";
    }
}
