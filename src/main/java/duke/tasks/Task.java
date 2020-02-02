package duke.tasks;

public class Task {
    protected String taskName;
    protected Boolean status;

    public Task(String taskName) {
        this.taskName = taskName;
        this.status = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        if (status) {
            return "[X]";
        } else {
            return "[ ]";
        }
    }

    public void setDone() {
        this.status = true;
    }

    @Override
    public String toString() {
        if (status) {
            return "[X] " + getTaskName();
        } else {
            return "[ ] " + getTaskName();
        }
    }
}
