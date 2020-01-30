package duke.Commands;

import duke.Tasks.Event;
import duke.Tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;
import java.io.IOException;


public class EventCommand extends Command {
    protected String taskName;
    protected String dateTime;

    public EventCommand(String taskName, String dateTime) {
        this.taskName = taskName;
        this.dateTime = dateTime;
    }

    public boolean isExit() {
        return false;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            taskList.addTask(new Event(taskName, dateTime));
            storage.write(taskList);
        } catch (IOException e) {
            System.out.println("IOException: Error in writing back changes.");
        }
    }
}
