package duke.util;

public class Ui {
    public static final String border = "=^..^=   =^..^=   =^..^=\n";

    public Ui() {

    }

    public static String setBorder(String msg) {
        return border + "\n\t" + msg + "\n\n" + border;
    }

    /**
     * Prints welcome message and instructions at start of program.
     */
    public static String welcomeMsg() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n\n";
        String instructions = "P.S please format all dates and times to YYYY-MM-DD HHMM or my head will explode.";
        return "Greetings mortal, my name is\n" + logo + "How may I help you?\n" + instructions;
    }

    public String exitMsg() {
        return setBorder("See u the next time you test ur code :P");
    }

}
