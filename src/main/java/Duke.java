import duke.Commands.Command;
import duke.Commands.DeadlineCommand;
import duke.Commands.DoneCommand;
import duke.Commands.EventCommand;
import duke.Exceptions.DukeException;
import duke.Tasks.TaskList;
import duke.util.Parser;
import duke.util.Storage;
import duke.util.Ui;

public class Duke {
    private Ui ui;
    private Storage storage;
    private TaskList taskList;

    public Duke(String fileName) {
        this.ui = new Ui();
        this.storage = new Storage(fileName);
        try {
            taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            System.out.println(e.toString());
        }
    }

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

    public static void main(String[] args) throws DukeException {
        new Duke("duke.txt").run();
    }
}