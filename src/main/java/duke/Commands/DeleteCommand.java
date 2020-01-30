package duke.Commands;

import duke.Tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;

import java.io.IOException;

public class DeleteCommand extends Command {
    protected int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    public boolean isExit() {
        return false;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            taskList.deleteTask(index);
            storage.write(taskList);
        } catch (IOException e) {
            System.out.println("IOException: Error in writing back changes.");
        }
    }
}
