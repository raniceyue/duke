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
