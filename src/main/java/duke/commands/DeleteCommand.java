package duke.commands;

import duke.exceptions.DukeBadIndexException;
import duke.exceptions.DukeWriteFailException;
import duke.tasks.Task;
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

    public String execute(
            TaskList taskList, Ui ui, Storage storage) throws DukeBadIndexException, DukeWriteFailException {
        Task t = taskList.getList().get(index - 1);
        taskList.deleteTask(index);
        storage.write(taskList);
        return Ui.setBorder("OK, I've removed the task:\n\t\t" + t + "\n"
                + "\tYou now have " + (taskList.getList().size()) + " task(s) on your list.");
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
