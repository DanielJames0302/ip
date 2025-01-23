import task.*;

import java.util.Scanner;

public class Buddy {
    private TaskList taskList;
    private Ui ui;
    private boolean isRunning;

    public Buddy() {
        this.isRunning = true;
        this.taskList = new TaskList();
        this.ui = new Ui();
    }

    private void start() {
        System.out.println(Ui.greet());

        while(this.isRunning) {
            String userInput = this.ui.readInput();
            System.out.println(this.response(userInput));
        }
    }

    private String response(String userInput) {
        return switch (Parser.parseInput(userInput)) {
            case BYE -> {
                this.exit();
                yield Ui.bye();
            }
            case LIST -> Ui.listTasks(this.taskList);
            case TODO -> this.addTodo(Parser.parseCommandInfo(userInput));
            case DEADLINE -> this.addDeadline(Parser.parseCommandInfo(userInput));
            case EVENT -> this.addEvent(Parser.parseCommandInfo(userInput));
            case MARK -> this.markTask(Parser.parseCommandInfo(userInput));
            case UNMARK -> this.unmarkTask(Parser.parseCommandInfo(userInput));
        };
    }

    private String addTodo(String commandInfo) {
        Task task = new Todo(commandInfo);
        this.taskList.addTask(task);
        return Ui.addTask(task, taskList);
    }

    private String addDeadline(String commandInfo) {
        String[] commandArgs = commandInfo.split(" /by ", 2);
        Task task = new Deadline(commandArgs[0], commandArgs[1]);
        this.taskList.addTask(task);
        return Ui.addTask(task, taskList);
    }

    private String addEvent(String commandInfo) {
        String[] commandArgs = commandInfo.split(" /from ", 2);
        String description = commandArgs[0];
        String[] time = commandArgs[1].split(" /to ", 2);
        Task task = new Event(description, time[0], time[1]);
        this.taskList.addTask(task);
        return Ui.addTask(task, taskList);
    }

    private String markTask(String commandInfo) {
        Task task = this.taskList.getTask(Integer.parseInt(commandInfo) - 1);
        task.markTaskAsDone();
        return Ui.markTask(task);
    }

    private String unmarkTask(String commandInfo) {
        Task task = this.taskList.getTask(Integer.parseInt(commandInfo) - 1);
        task.unmarkTaskAsDone();
        return Ui.unmarkTask(task);
    }

    public void exit() {
        this.isRunning = false;
        this.ui.closeInput();
    }

    public static void main(String[] args) {
        new Buddy().start();
    }
}
