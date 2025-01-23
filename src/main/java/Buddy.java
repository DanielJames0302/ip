import exception.BuddyException;
import exception.BuddyInvalidCommandArgumentsException;
import exception.BuddyInvalidCommandException;
import exception.BuddyTaskNotFoundException;
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
        try{
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
                case DELETE -> this.deleteTask(Parser.parseCommandInfo(userInput));
                default -> throw new BuddyInvalidCommandException(userInput);
            };
        } catch(BuddyException error) {
            return Ui.showError(error);
        }

    }

    private String addTodo(String commandInfo) throws BuddyException {
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

    private String markTask(String commandInfo) throws BuddyException {
        try {
            Task task = this.taskList.getTask(Integer.parseInt(commandInfo) - 1);
            task.markTaskAsDone();
            return Ui.markTask(task);
        } catch (NumberFormatException error) {
          throw new BuddyInvalidCommandArgumentsException();
        } catch(IndexOutOfBoundsException error) {
            throw new BuddyTaskNotFoundException(this.taskList.getLength());
        }

    }

    private String unmarkTask(String commandInfo) throws BuddyException {
        try {
            Task task = this.taskList.getTask(Integer.parseInt(commandInfo) - 1);
            task.unmarkTaskAsDone();
            return Ui.unmarkTask(task);
        } catch (NumberFormatException error) {
            throw new BuddyInvalidCommandArgumentsException();
        } catch(IndexOutOfBoundsException error) {
            throw new BuddyTaskNotFoundException(this.taskList.getLength());
        }
    }

    public String deleteTask(String commandInfo) throws BuddyException {
        try {
            int taskId = Integer.parseInt(commandInfo);
            if (taskId > this.taskList.getLength() || taskId < 0) {
                throw new BuddyInvalidCommandArgumentsException();
            }
            Task taskToDelete = this.taskList.getTask(Integer.parseInt(commandInfo) - 1);
            this.taskList.deleteTask(taskToDelete);
            return Ui.deleteTask(taskToDelete, taskList);
        } catch (NumberFormatException error) {
            throw new BuddyInvalidCommandArgumentsException();
        } catch(IndexOutOfBoundsException error) {
            throw new BuddyTaskNotFoundException(this.taskList.getLength());
        }
    }

    public void exit() {
        this.isRunning = false;
        this.ui.closeInput();
    }

    public static void main(String[] args) {
        new Buddy().start();
    }
}
