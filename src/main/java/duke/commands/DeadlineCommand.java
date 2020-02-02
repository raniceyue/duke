package duke.commands;

import duke.exceptions.DukeWriteFailException;
import duke.tasks.Deadline;
import duke.tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;

public class DeadlineCommand extends Command {
    String taskName;
    String dateTime;

    public DeadlineCommand(String taskName, String dateTime) {
        this.taskName = taskName;
        this.dateTime = dateTime;
    }

    public boolean isExit() {
        return false;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeWriteFailException {
        taskList.addTask(new Deadline(taskName, dateTime));
        storage.write(taskList);
    }

    @Override
    public boolean equals(Object command) {
        if (command instanceof DeadlineCommand) {
            if (((DeadlineCommand) command).taskName.equals(this.taskName)) {
                return ((DeadlineCommand) command).dateTime.equals(this.dateTime);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
