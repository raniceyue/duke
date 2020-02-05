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


    /**
     * Method to run Duke program.
     * @throws DukeException if an exception occurs during the program.
     */
    /*
    public void run() throws DukeException {
        ui.printWelcomeMsg();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parseCommand(fullCommand);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                System.out.println(e.toString());
            }
        }
    }
    */

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        try {
            Command c = Parser.parseCommand(input);
            return c.execute(taskList, ui, storage);
        } catch (DukeException e) {
            return e.toString();
        }
    }
}