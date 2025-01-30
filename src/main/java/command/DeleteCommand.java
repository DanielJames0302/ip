package command;

import display.Display;
import exception.BuddyException;
import exception.BuddyInvalidCommandArgumentsException;
import exception.BuddyTaskNotFoundException;
import storage.DataStorage;
import task.Task;
import task.TaskList;

import java.util.ArrayList;

public class DeleteCommand extends Command {

    public DeleteCommand(ArrayList<String> args) {
        super(args);
    }

    public String execute(TaskList taskList, DataStorage dataStorage) throws BuddyException {
        try {
            int taskId = Integer.parseInt(args.get(0));
            if (taskId > taskList.getLength() || taskId < 0) {
                throw new BuddyInvalidCommandArgumentsException(String.format("Your task id should be in the range" +
                        "0 - %s", taskList.getLength()));
            }
            Task taskToDelete = taskList.getTask(Integer.parseInt(args.get(0)) - 1);
            taskList.deleteTask(taskToDelete);
            dataStorage.saveTasksToStorage(taskList);
            return Display.deleteTask(taskToDelete, taskList);
        } catch (NumberFormatException error) {
            throw new BuddyInvalidCommandArgumentsException("Your task id needs to be a number.");
        } catch(IndexOutOfBoundsException error) {
            throw new BuddyTaskNotFoundException(taskList.getLength());
        }
    }
}
