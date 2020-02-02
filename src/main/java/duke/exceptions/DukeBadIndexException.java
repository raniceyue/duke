package duke.Exceptions;

public class DukeBadIndexException extends DukeException {
    public DukeBadIndexException(int index) {
        if (index < 0) {
            super.message = "You can't enter a negative index!!";
        } else {
            super.message = "I don't think you have that many tasks my dude.";
        }
    }
}
