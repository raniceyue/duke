package duke.exceptions;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;

public class DukeDuplicateTaskException extends DukeException {
    public DukeDuplicateTaskException(Task t) {
        if (t instanceof Event) {
            super.message = "DUPLICATE TASK!! " + t.getTaskName() + " @ " + ((Event) t).getDateTime() + " is already in the task list!!";
        } else if (t instanceof Deadline) {
            super.message = "DUPLICATE TASK!! " + t.getTaskName() + " by " + ((Deadline) t).getDateTime() + " is already in the task list!!";
        } else {
            super.message = "DUPLICATE TASK!! " + t.getTaskName() + " is already in the task list!!";
        }
    }
}
