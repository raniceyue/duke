public class Event extends Task {
    protected String date;

    public Event(String taskName, String date) {
        super(taskName);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return "[E]";
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + getDate() + ")";
    }
}
