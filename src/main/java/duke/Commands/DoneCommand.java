package duke.Commands;

import duke.Tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;
import java.io.IOException;

public class DoneCommand extends Command {
    protected int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    public boolean isExit() {
        return false;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            taskList.setDone(index);
            storage.write(taskList);
        } catch (IOException e) {
            System.out.println("IOException caught!");
        }
    }
}
