public class DukeNoDescriptionException extends DukeException {
    public DukeNoDescriptionException(String taskName) {
        super.message = "You need to specify more details for task " + taskName + "!!";
    }
}
