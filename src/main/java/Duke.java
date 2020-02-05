import duke.commands.Command;
import duke.exceptions.DukeException;
import duke.tasks.TaskList;
import duke.util.Parser;
import duke.util.Storage;
import duke.util.Ui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Duke extends Application {
    private Ui ui;
    private Storage storage;
    private TaskList taskList;

    public Duke() {

    }

    /**
     * Constructor for Duke.
     * @param fileName file name of file to store and load task list data.
     */
    public Duke(String fileName) {
        this.ui = new Ui();
        this.storage = new Storage(fileName);
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

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        ScrollPane scrollPane = new ScrollPane();
        VBox dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        TextField userInput = new TextField();
        Button sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.

        // Part 2.2
        stage.setTitle("Duke UI");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        mainLayout.setPrefSize(400.0, 600.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);
    }
}