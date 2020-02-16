package duke.exceptions;

public class DukeFileExistsException extends DukeException {
    public DukeFileExistsException() {
        super.message = "A file named duke.txt already exists!";
    }
}
