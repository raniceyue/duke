package duke.Commands;

import duke.Exceptions.DukeWriteFailException;
import duke.Tasks.Event;
import duke.Tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;


public class EventCommand extends Command {
    protected String taskName;
    protected String dateTime;

    public EventCommand(String taskName, String dateTime) {
        this.taskName = taskName;
        this.dateTime = dateTime;
    }

    public boolean isExit() {
        return false;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeWriteFailException {
        taskList.addTask(new Event(taskName, dateTime));
        storage.write(taskList);
    }

    @Override
    public boolean equals(Object command) {
        if (command instanceof EventCommand) {
            if (((EventCommand) command).taskName.equals(this.taskName)) {
                return ((EventCommand) command).dateTime.equals(this.dateTime);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
