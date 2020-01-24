public class Event extends Task {
    protected String date;

    public Event(String taskName, String date) {
        super(taskName);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + getDate() + ")";
    }
}
