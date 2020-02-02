package duke.exceptions;

public class DukeBadDateException extends DukeException {
    public DukeBadDateException() {
        super.message = "The date you have entered is in a bad format!\n\tPlease use the format YYYY-MM-DD.";
    }
}
