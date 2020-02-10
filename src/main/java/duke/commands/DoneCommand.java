package duke.commands;

import duke.exceptions.DukeBadIndexException;
import duke.exceptions.DukeWriteFailException;
import duke.tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;

public class DoneCommand extends Command {
    protected int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    public boolean isExit() {
        return false;
    }

    /**
     * Method to execute 'done' command.
     * @param taskList task list in running program.
     * @param ui ui handling running program.
     * @param storage storage handling running program.
     * @throws DukeWriteFailException if the program fails to write the modified data to the storage file.
     */
    public String execute(
            TaskList taskList, Ui ui, Storage storage) throws DukeBadIndexException, DukeWriteFailException {
        taskList.setDone(index);
        storage.write(taskList);
        return Ui.setBorder("I've marked (" + index + ") as done!\n"
                + "\t(" + index + ") " + taskList.getList().get(index - 1));
    }

    @Override
    public boolean equals(Object command) {
        if (command instanceof DoneCommand) {
            return this.index == ((DoneCommand) command).index;
        } else {
            return false;
        }
    }
}
