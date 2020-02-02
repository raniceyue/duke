package duke.Tasks;

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
        this.time = dt[1];
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
    public boolean equals(Object task) {
        if (task instanceof Event) {
            if (((Event)task).getTaskName().equals(this.getTaskName())) {
                if (((Event) task).getDateTime().equals(this.getDateTime())) {
                    return ((Event) task).getStatus() == this.getStatus();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + getDateTime() + ")";
    }
}
