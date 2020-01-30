package duke.Commands;

import duke.Tasks.Deadline;
import duke.Tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;

import java.io.IOException;

public class DeadlineCommand extends Command {
    String taskName;
    String dateTime;

    public DeadlineCommand(String taskName, String dateTime) {
        this.taskName = taskName;
        this.dateTime = dateTime;
    }

    public boolean isExit() {
        return false;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            taskList.addTask(new Deadline(taskName, dateTime));
            storage.write(taskList);
        } catch (IOException e) {
            System.out.println("IOException: Error in writing back changes.");
        }
    }
}
