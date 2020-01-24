public class DukeException extends Exception {
    protected String message;

    @Override
    public String toString() {
        String output = "=^..^=   =^..^=   =^..^=    =^..^=    =^..^=    =^..^=    =^..^=\n\n"
                        + "\t" + message + "\n\n"
                        + "=^..^=   =^..^=   =^..^=    =^..^=    =^..^=    =^..^=    =^..^=\n\n";
        return output;
    }
}
