package duke.Tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline task.
 */
public class Deadline extends Task {
    protected LocalDate date;
    protected String time;
    protected String RawDate;

    /**
     * Constructor for a deadline task.
     * @param taskName name of deadline.
     * @param DateTime date and time of deadline.
     */
    public Deadline(String taskName, String DateTime) {
        super(taskName);
        String[] dt = DateTime.split(" ");
        this.RawDate = dt[0];
        this.date = LocalDate.parse(getRawDate());
        this.time = dt[1];
    }

    /**
     * Get the date in d MMM yyyy format, e.g. 05 January 2020.
     * @return string of date in the format d MMM yyyy
     */
    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
    }

    public String getTime() {
        return this.time;
    }

    public String getDateTime() {
        return getDate() + " " + getTime();
    }

    /**
     * Get the date in yyyy-mm-dd format as in input, e.g. 2020-02-02.
     * @return string of date in the format yyyy-mm-dd.
     */
    public String getRawDate() {
        return RawDate;
    }

    /**
     * Method to return type of command as a string.
     * @return string stating type of command.
     */
    public String getType() {
        return "[D]";
    }

    /**
     * Method to re-format task into a format readable by parser when loading data from storage file.
     * @return string in a format readable by parser.
     */
    public String WriteFormat() {
        return getType() + getStatus() + " " + getTaskName() + " /by " + getRawDate() + " " + getTime();
    }

    @Override
    public boolean equals(Object task) {
        if (task instanceof Deadline) {
            if (((Deadline) task).getTaskName().equals(this.getTaskName())) {
                if (((Deadline) task).getDateTime().equals(this.getDateTime())) {
                    return ((Deadline) task).getStatus() == this.getStatus();
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
        return "[D]" + super.toString() + " (due by: " + getDateTime() + ")";
    }
}
