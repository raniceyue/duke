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
                String output = border + "\n\t" + "ADDED : ";
                if (command.equals("todo")) {
                    String item = parse.nextLine();
                    list[numItems + 1] = new ToDo(item);
                    numItems++;
                    output += list[numItems] + "\n\n" + border;
                    System.out.println(output);
                } else if (command.equals("event")) {
                    String item = parse.nextLine();
                    String[] details = item.split("/at");
                    list[numItems + 1] = new Event(details[0], details[1]);
                    numItems++;
                    output += list[numItems] + "\n\n" + border;
                    System.out.println(output);
                } else if (command.equals("deadline")) {
                    String item = parse.nextLine();
                    String[] details = item.split("/by");
                    list[numItems + 1] = new Deadline(details[0], details[1]);
                    numItems++;
                    output += list[numItems] + "\n\n" + border;
                    System.out.println(output);
                } else {
                    list[numItems + 1] = new Task(input);
                    numItems++;
                    output += input + "\n\n" + border;
                    System.out.println(output);
                }
            }
        }
    }
}
