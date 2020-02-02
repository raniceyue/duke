package duke.util;

import java.util.Scanner;

/**
 * Class to handle user input and program outputs.
 */
public class Ui {
    public static final String border = "=^..^=   =^..^=   =^..^=    =^..^=    =^..^=    =^..^=    =^..^=\n";

    /**
     * Constructor for Ui.
     */
    public Ui() { }

    /**
     * Method to read single line of command.
     * @return returns the read command as a string.
     */
    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        String command = "";
        while (sc.hasNextLine()) {
            command = sc.nextLine().strip();
            break;
        }
        return command;
    }

    /**
     * Method to wrap border decoration around message.
     * @param msg message to be put inside border.
     * @return string containing message decorated with border.
     */
    public static String setBorder(String msg) {
        return border + "\n\t" + msg + "\n\n" + border;
    }

    public static void printWelcomeMsg() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n\n";
        System.out.println("Greetings mortal, my name is\n" + logo + "How may I help you?\n");
    }

    public static void printExitMsg() {
        String toPrint = setBorder("See u the next time you test ur code :P");
        System.out.println(toPrint);
    }

}
