import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDate date;
    protected String time;

    public Deadline(String taskName, String DateTime) {
        super(taskName);
        String[] dt = DateTime.split(" ");
        String date = dt[0];
        String time = dt[1];
        this.date = LocalDate.parse(dt[0]);
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

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (due by: " + getDateTime() + ")";
    }
}
