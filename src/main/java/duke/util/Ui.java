package duke.util;

public class Ui {
    public static final String border = "=^..^=   =^..^=   =^..^=\n";

    public Ui() {

    }

    /**
     * Method to read user input.
     * @return String containing user input.
     */
    /*
    public String output() {

    }
    */


    public static String setBorder(String msg) {
        return border + "\n\t" + msg + "\n\n" + border;
    }

    /**
     * Method to print welcome message at start of program.
     */
    public static String welcomeMsg() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n\n";
        return "Greetings mortal, my name is\n" + logo + "How may I help you?\n";
    }

    public String exitMsg() {
        return setBorder("See u the next time you test ur code :P");
    }

}
