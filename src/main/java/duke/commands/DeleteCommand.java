package duke.commands;

import duke.exceptions.DukeBadIndexException;
import duke.exceptions.DukeWriteFailException;
import duke.tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;

public class DeleteCommand extends Command {
    protected int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    public boolean isExit() {
        return false;
    }

    public void execute(
            TaskList taskList, Ui ui, Storage storage) throws DukeBadIndexException, DukeWriteFailException {
        taskList.deleteTask(index);
        storage.write(taskList);
    }

    @Override
    public boolean equals(Object command) {
        if (command instanceof DeleteCommand) {
            return this.index == ((DeleteCommand) command).index;
        } else {
            return false;
        }
    }

}
