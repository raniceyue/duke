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

        Task[] list = new Task[101];
        int numItems = 0;

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            Scanner parse = new Scanner(input);
            String command = parse.next();

            if (command.equals("bye")) {
                String output = border + "\n" + "\tSee u the next time you test ur code :P\n\n" + border;
                System.out.println(output);
                break;
            } else if (command.equals("list")) {
                String output = border + "\n\tHere is your list:\n";
                for (int i = 1; list[i] != null; i++) {
                    output += "\t(" + i + ") " + list[i] + "\n";
                }
                output += "\n" + border;
                System.out.println(output);
            } else if (command.equals("done")) {
                int index = parse.nextInt();
                list[index].setDone();
                String output = border + "\n\tI've marked (" + index + ") as done!\n";
                output += "\t(" + index + ") " + list[index] + "\n\n" + border;
                System.out.println(output);
            } else {
                list[numItems + 1] = new Task(input);
                numItems++;
                String output = border + "\n\t ADDED: " + input + "\n\n" + border;
                System.out.println(output);
            }
        }
    }
}
