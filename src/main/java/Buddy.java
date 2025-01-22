import java.util.Scanner;

public class Buddy {
    public static void main(String[] args) {
        String border = "____________________________________________________________";
        System.out.println(border);
        System.out.println("Hello! I'm Buddy\n");
        System.out.println("What can I do for you?");
        System.out.println(border);

        Task[] tasks = new Task[100];
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
                    System.out.println(" " + i + ". " +
                            tasks[i].toString() + "\n");
                }
            } else if (command.startsWith("mark ")) {
                int task_id = Integer.parseInt(command.split(" ")[1]) - 1;
                if (task_id >= 0 && task_id <= tasks.length) {
                    tasks[task_id].markTaskAsDone();
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println("  " + tasks[task_id].toString());
                }

            } else if (command.startsWith("unmark ")) {
                int task_id = Integer.parseInt(command.split(" ")[1]) - 1;
                if (task_id >= 0 && task_id <= tasks.length) {
                    tasks[task_id].unmarkTaskAsDone();
                    System.out.println(" OK, I've marked this task as not done yet:");
                    System.out.println("  " + tasks[task_id].toString());
                }
            } else {
                System.out.println(" added: " + command);
                tasks[taskCount] = new Task(command);
                taskCount += 1;
            }

            System.out.println(" " + border);
        } while(!command.equals("bye"));

        scanner.close();
    }
}
