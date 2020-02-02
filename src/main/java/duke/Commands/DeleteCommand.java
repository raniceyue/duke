package duke.Commands;

import duke.Exceptions.DukeBadIndexException;
import duke.Exceptions.DukeWriteFailException;
import duke.Tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;

import java.io.IOException;

/**
 * Represents the command 'delete'.
 */

public class DeleteCommand extends Command {
    protected int index;

    /**
     * Constructor for DeleteCommand.
     * @param index of task to be deleted from list.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Method to check if command is the exit command.
     * @return boolean stating if command is an exit command
     */
    public boolean isExit() {
        return false;
    }

    /**
     * Method to execute 'deadline' command.
     * @param taskList task list in running program.
     * @param ui ui handling running program.
     * @param storage storage handling running program.
     * @throws DukeBadIndexException if index for command is out of range of the task list indices.
     * @throws DukeWriteFailException if the program fails to write the modified data to the storage file.
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeBadIndexException, DukeWriteFailException {
        taskList.deleteTask(index);
        storage.write(taskList);
    }

    /**
     * Method to compare 2 commands.
     * @param command object to compare command to.
     * @return boolean stating if this command and command are equal.
     */
    @Override
    public boolean equals(Object command) {
        if (command instanceof DeleteCommand) {
            return this.index == ((DeleteCommand) command).index;
        } else {
            return false;
        }
    }

}
