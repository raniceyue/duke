package duke.Commands;

import duke.Exceptions.DukeWriteFailException;
import duke.Tasks.Deadline;
import duke.Tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;

/**
 * Represents the command 'deadline'.
 */
public class DeadlineCommand extends Command {
    String taskName;
    String dateTime;

    /**
     * Creates a command to create a Deadline task.
     * @param taskName name of deadline.
     * @param dateTime date and time of deadline.
     */
    public DeadlineCommand(String taskName, String dateTime) {
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
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeWriteFailException {
        taskList.addTask(new Deadline(taskName, dateTime));
        storage.write(taskList);
    }

    /**
     * Method to compare 2 commands.
     * @param command object to compare command to.
     * @return boolean stating if this command and command are equal.
     */
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
