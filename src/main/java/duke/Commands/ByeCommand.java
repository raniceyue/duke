package duke.Commands;

import duke.Tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;

/**
 * Represents the command 'bye'.
 */
public class ByeCommand extends Command {

    /**
     * Method to check if command is the exit command.
     * @return boolean stating if command is an exit command
     */
    public boolean isExit() {
        return true;
    }

    /**
     * Method to execute 'bye' command.
     * @param taskList task list in running program.
     * @param ui ui handling running program.
     * @param storage storage handling running program.
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.printExitMsg();
    }

    /**
     * Method to compare 2 commands.
     * @param command object to compare command to.
     * @return boolean stating if this command and command are equal.
     */
    @Override
    public boolean equals(Object command) {
        return command instanceof ByeCommand;
    }
}
