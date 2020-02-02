package duke.commands;

import duke.tasks.TaskList;
import duke.util.Storage;
import duke.util.Ui;

import java.util.List;

public class FindCommand extends Command {
    String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    public boolean isExit() {
        return false;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        TaskList results = taskList.search(keyword);
        String toPrint = "";
        if (results.numTasks() > 0) {
            toPrint += "Here are the matching tasks in your list!!\n";
            for (int i = 0; i < results.numTasks(); i++) {
                toPrint += "\t(" + (i + 1) + ") " + results.getList().get(i) + "\n";
            }
        } else if (results.numTasks() == 0) {
            toPrint += "There are no matching results in your list.";
        } else if (taskList.numTasks() == 0) {
            toPrint += "You have nothing on your list.";
        }
        System.out.println(Ui.setBorder(toPrint));
    }

    @Override
    public boolean equals(Object command) {
        return command instanceof FindCommand;
    }
}
