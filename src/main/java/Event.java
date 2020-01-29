import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate date;
    protected String time;
    protected String RawDate;

    public Event(String taskName, String DateTime) {
        super(taskName);
        String[] dt = DateTime.split(" ");
        this.RawDate = dt[0];
        this.date = LocalDate.parse(getRawDate());
        String time = dt[1];
        this.time = time;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
    }

    public String getTime() {
        return this.time;
    }

    public String getDateTime() {
        return getDate() + " " + getTime();
    }

    public String getRawDate() {
        return RawDate;
    }

    public String getType() {
        return "[E]";
    }

    public String WriteFormat() {
        return getType() + getStatus() + " " + getTaskName() + " /at " + getRawDate() + " " + getTime();
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + getDateTime() + ")";
    }
}
