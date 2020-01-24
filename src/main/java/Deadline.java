public class Deadline extends Task {
    protected String date;

    public Deadline(String taskName, String date) {
        super(taskName);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (Due by: " + getDate() + ")";
    }
}
