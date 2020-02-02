package duke.commands;

import duke.tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;

public class ListCommand extends Command {

    public ListCommand() {

    }

    public boolean isExit() {
        return false;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        System.out.println(taskList.toString());
    }

    @Override
    public boolean equals(Object command) {
        return command instanceof ListCommand;
    }
}
