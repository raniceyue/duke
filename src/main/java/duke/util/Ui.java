package duke.util;

import java.util.Scanner;

public class Ui {
    public static final String border = "=^..^=   =^..^=   =^..^=    =^..^=    =^..^=    =^..^=    =^..^=\n";

    public Ui() { }

    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        String command = "";
        while (sc.hasNextLine()) {
            command = sc.nextLine().strip();
            break;
        }
        return command;
    }

    /*Wraps border around msg*/
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
