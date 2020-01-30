package duke.Tasks;

public class ToDo extends Task {

    public ToDo(String taskName) {
        super(taskName);
    }

    public String getType() {
        return "[T]";
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
