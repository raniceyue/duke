public class DukeNoDateException extends DukeException {
    public DukeNoDateException(String taskName) {
        if (taskName.equals("deadline")) {
            super.message = "Doesn't a deadline have a date?? Aren't you forgetting something??";
        } else {
            super.message = "When is this even supposed to happen? You forgot the date!";
        }
    }
}
