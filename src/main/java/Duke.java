import java.io.*;

public class Duke {
    private Ui ui;
    private Storage storage;
    private TaskList taskList;

    public Duke(String fileName) {
        this.ui = new Ui();
        this.storage = new Storage(fileName);
        try {
            taskList = new TaskList(storage.load());
        } catch (IOException e) {
            System.out.println("IOException, failed to load storage.");
        } catch (DukeException e) {
            System.out.println(e.toString());
        }
    }

    public void run() {
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

    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }
}