import java.util.Scanner;

public class Buddy {
    public static void main(String[] args) {
        String border = "____________________________________________________________";
        System.out.println(border);
        System.out.println("Hello! I'm Buddy\n");
        System.out.println("What can I do for you?");
        System.out.println(border);

        String[] tasks = new String[100];
        int taskCount = 0;

        Scanner scanner = new Scanner(System.in);
        String command = "";

        do {
            command = scanner.nextLine();
            System.out.println(" " + border);

            if (command.equals("bye")) {
                System.out.println(" Bye. Hope to see you again soon!");
            } else if (command.equals("list")) {
                for (int i = 0; i < taskCount; i += 1) {
                    System.out.println(" " + i + ". " +  tasks[i] + "\n");
                }
            } else {
                System.out.println(" added: " + command);
                tasks[taskCount] = command;
                taskCount += 1;
            }

            System.out.println(" " + border);
        } while(!command.equals("bye"));

        scanner.close();
    }
}
