package duke.commands;

import duke.exceptions.DukeWriteFailException;
import duke.tasks.TaskList;
import duke.tasks.ToDo;
import duke.util.Storage;
import duke.util.Ui;

/**
 * Represents the command 'todo'.
 */
public class ToDoCommand extends Command {
    String taskName;

    /**
     * Constructor for ToDoCommand.
     * @param taskName name of task to be done.
     */
    public ToDoCommand(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Method to check if command is the exit command.
     * @return boolean stating if command is an exit command
     */
    public boolean isExit() {
        return false;
    }

    /**
     * Method to execute 'todo' command.
     * @param taskList task list in running program.
     * @param ui ui handling running program.
     * @param storage storage handling running program.
     * @throws DukeWriteFailException if the program fails to write the modified data to the storage file.
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeWriteFailException {
        taskList.addTask(new ToDo(taskName));
        storage.write(taskList);
    }

    /**
     * Method to compare 2 commands.
     * @param command object to compare command to.
     * @return boolean stating if this command and command are equal.
     */
    @Override
    public boolean equals(Object command) {
        if (command instanceof ToDoCommand) {
            return this.taskName.equals(((ToDoCommand) command).taskName);
        } else {
            return false;
        }
    }
}
