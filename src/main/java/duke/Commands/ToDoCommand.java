package duke.Commands;
import duke.Tasks.*;
import duke.util.*;

import java.io.IOException;

public class ToDoCommand extends Command {
    String taskName;

    public ToDoCommand(String taskName) {
        this.taskName = taskName;
    }

    public boolean isExit() {
        return false;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            taskList.addTask(new ToDo(taskName));
            storage.write(taskList);
        } catch (IOException e) {
            System.out.println("IOException: Error in writing back changes.");
        }
    }
}
