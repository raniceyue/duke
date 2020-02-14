package duke.commands;

import duke.exceptions.DukeWriteFailException;
import duke.tasks.Event;
import duke.tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;

/**
 * Represents the command 'event'.
 */
public class EventCommand extends Command {
    protected String taskName;
    protected String dateTime;

    /**
     * Constructor for EventCommand.
     * @param taskName name of event.
     * @param dateTime date and time of event occurrence.
     */
    public EventCommand(String taskName, String dateTime) {
        assert !taskName.isEmpty();
        this.taskName = taskName;
        this.dateTime = dateTime;
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
     * @throws DukeWriteFailException if the program fails to write the modified data to the storage file.
     */
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeWriteFailException {
        Event t = new Event(taskName, dateTime);
        taskList.addTask(t);
        storage.write(taskList);
        return Ui.setBorder("ADDED : " + t.toString() + "\n"
                + "\tYou now have " + taskList.numTasks() + " item(s) on your list.");
    }

    /**
     * Method to compare 2 commands.
     * @param command object to compare command to.
     * @return boolean stating if this command and command are equal.
     */
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
