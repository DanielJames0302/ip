import java.util.Scanner;

public class Buddy {
    public static void main(String[] args) {
        String border = "____________________________________________________________";
        System.out.println(border);
        System.out.println("Hello! I'm Buddy\n");
        System.out.println("What can I do for you?");
        System.out.println(border);
        Scanner scanner = new Scanner(System.in);
        String command = "";
        do {
            command = scanner.nextLine(); // Read user input
            if (command.equals("bye")) {
                System.out.println(border);
                System.out.println(" Bye. Hope to see you again soon!");
                System.out.println(border);
            } else {
                System.out.println(border);
                System.out.println(" " + command); // Echo the command
                System.out.println(border);
            }

        } while(!command.equals("bye"));
        scanner.close();
    }
}
