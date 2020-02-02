package duke.commands;

import duke.tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;

public class ByeCommand extends Command {

    public boolean isExit() {
        return true;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.printExitMsg();
    }

    @Override
    public boolean equals(Object command) {
        return command instanceof ByeCommand;
    }
}
