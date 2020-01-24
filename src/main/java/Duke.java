import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {

        String border = "=^..^=   =^..^=   =^..^=    =^..^=    =^..^=    =^..^=    =^..^=\n";
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n\n";
        System.out.println("Greetings mortal, my name is\n" + logo + "How may I help you?\n");

        String[] list = new String[101];
        int numItems = 0;

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                String output = border + "\n" + "\tSee u the next time you test ur code :P\n\n" + border;
                System.out.println(output);
                break;
            } else if (input.equals("list")) {
                String output = border + "\n\tHere is your list:\n";
                for (int i = 1; list[i] != null; i++) {
                    output += "\t(" + i + ") " + list[i] + "\n";
                }
                output += "\n" + border;
                System.out.println(output);
            } else {
                list[numItems + 1] = input;
                numItems++;
                String output = border + "\n\t ADDED: " + input + "\n\n" + border;
                System.out.println(output);
            }
        }
    }
}
