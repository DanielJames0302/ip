package command;

import display.Display;
import exception.BuddyException;
import exception.BuddyInvalidCommandArgumentsException;
import exception.BuddyTaskNotFoundException;
import storage.DataStorage;
import task.Task;
import task.TaskList;

import java.util.ArrayList;

public class UnmarkCommand extends Command {

    public UnmarkCommand(ArrayList<String> args) {
        super(args);
    }

    @Override
    public String execute(TaskList taskList, DataStorage dataStorage) throws BuddyException {
        try {
            Task task = taskList.getTask(Integer.parseInt(args.get(0)) - 1);
            task.unmarkTaskAsDone();
            dataStorage.saveTasksToStorage(taskList);
            return Display.unmarkTask(task);
        } catch (NumberFormatException error) {
            throw new BuddyInvalidCommandArgumentsException("Your task id needs to be a number");
        } catch(IndexOutOfBoundsException error) {
            throw new BuddyTaskNotFoundException(taskList.getLength());
        }
    }
}
