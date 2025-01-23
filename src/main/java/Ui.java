import task.Task;
import task.TaskList;

import java.util.Scanner;

public class Ui {
    private static final String BORDER = "\n____________________________________________________________\n";
    private final Scanner scanner = new Scanner(System.in);


    public static String greet() {
        return String.format(Ui.BORDER + "\n" +
                "Hello! I'm Buddy\n" + "What can I do for you?" +
                "\n" + Ui.BORDER);
    }

    public String readInput() {
        return this.scanner.nextLine();
    }

    public void closeInput() {
        this.scanner.close();
    }

    public static String bye() {
        return String.format(Ui.BORDER + "\n" +
                " Bye. Hope to see you again soon!\n" +
                  Ui.BORDER);
    }

    public static String markTask(Task task) {
        return Ui.BORDER + " Nice! I've marked this task as done:\n"
                + String.format(" %s", task.toString()) + Ui.BORDER;
    }

    public static String unmarkTask(Task task) {
        return Ui.BORDER + " OK, I've marked this task as not done yet:\n"
                + String.format(" %s", task.toString()) + Ui.BORDER;
    }

    public static String addTask(Task task, TaskList taskList) {
        return Ui.BORDER + String.format("  Got it. I've added this task: \n  %s",
                task.toString()) +
                String.format("\n  Now you have %s tasks in the list.", taskList.getLength())
                + Ui.BORDER;
    }

    public static String listTasks(TaskList taskList) {
        String result = Ui.BORDER + "  Here are the tasks in your list:\n";
        for (int i = 0; i < taskList.getLength(); i += 1) {
            result = result + String.format("  %s.%s\n", i + 1,
                    taskList.getTask(i).toString());
        }

        return result + Ui.BORDER;
    }


}
