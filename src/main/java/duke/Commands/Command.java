package duke.Commands;

import duke.Tasks.TaskList;
import duke.util.*;

public abstract class Command {
    public abstract void execute(TaskList taskList, Ui ui, Storage storage);
    public abstract boolean isExit();
}
