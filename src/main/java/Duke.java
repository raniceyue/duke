import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        String border = "=^..^=   =^..^=   =^..^=    =^..^=    =^..^=    =^..^=    =^..^=\n";
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n\n";
        System.out.println("Greetings mortal, my name is\n" + logo + "How may I help you?\n");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                String output = border + "\n" + "\tSee u the next time you test ur code :P\n\n" + border;
                System.out.println(output);
                break;
            } else {
                String output = border + "\n\t" + input + "\n\n" + border;
                System.out.println(output);
            }
        }
    }
}
