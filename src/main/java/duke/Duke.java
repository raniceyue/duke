package duke;

import duke.commands.Command;
import duke.exceptions.DukeException;
import duke.tasks.TaskList;
import duke.util.Parser;
import duke.util.Storage;
import duke.util.Ui;

public class Duke {
    private Ui ui;
    private Storage storage;
    private TaskList taskList;

    public Duke() {
        this.ui = new Ui();
        this.storage = new Storage("duke.txt");
        try {
            taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            System.out.println(e.toString());
        }
    }

     public String getResponse(String input) {
        try {
            Command c = Parser.parseCommand(input);
            return c.execute(taskList, ui, storage);
        } catch (DukeException e) {
            return e.toString();
        }
    }
}