package duke.commands;

import duke.exceptions.DukeWriteFailException;
import duke.tasks.TaskList;
import duke.tasks.ToDo;
import duke.util.Storage;
import duke.util.Ui;

public class ToDoCommand extends Command {
    String taskName;

    public ToDoCommand(String taskName) {
        this.taskName = taskName;
    }

    public boolean isExit() {
        return false;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeWriteFailException {
        taskList.addTask(new ToDo(taskName));
        storage.write(taskList);
    }

    @Override
    public boolean equals(Object command) {
        if (command instanceof ToDoCommand) {
            return this.taskName.equals(((ToDoCommand) command).taskName);
        } else {
            return false;
        }
    }
}
