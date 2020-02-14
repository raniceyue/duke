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

    /**
     * Creates new Duke object to be run by the launcher.
     */
    public Duke() {
        this.ui = new Ui();
        this.storage = new Storage("duke.txt");
        try {
            taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Processes user input and returns response from Duke.
     * @param input user input.
     * @return string containing response from Duke to be printed in the GUI.
     */
    public String getResponse(String input) {
        try {
            assert !input.isEmpty() : "YOU DIDN'T SAY ANYTHING!!";
            Command c = Parser.parseCommand(input);
            return c.execute(taskList, ui, storage);
        } catch (DukeException e) {
            return e.toString();
        }
    }
}