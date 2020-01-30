package duke.Commands;

import duke.Exceptions.DukeBadIndexException;
import duke.Exceptions.DukeWriteFailException;
import duke.Tasks.TaskList;
import duke.util.*;

public abstract class Command {
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws DukeBadIndexException, DukeWriteFailException;
    public abstract boolean isExit();
}
