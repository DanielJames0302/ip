package command;

import display.Display;
import exception.BuddyException;
import exception.BuddyInvalidCommandArgumentsException;
import storage.DataStorage;
import task.Deadline;
import task.Event;
import task.Task;
import task.TaskList;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AddEventCommand extends Command {

    public AddEventCommand(ArrayList<String> args) {
        super(args);
    }

    public String execute(TaskList taskList, DataStorage dataStorage) throws BuddyException {
        try {
            LocalDateTime from = Command.getDateAndTime(args.get(1));
            LocalDateTime to = Command.getDateAndTime(args.get(2));
            Task task = new Event(args.get(0), from, to);
            taskList.addTask(task);
            dataStorage.saveTasksToStorage(taskList);
            return Display.addTask(task, taskList);
        } catch(IndexOutOfBoundsException error) {
            throw new BuddyInvalidCommandArgumentsException("Please enter event command in the" +
                    "following format \\`event [description] /from [dd/mm/yyyy HHmm] /to [dd/mm/yyyy HHmm]\\`");
        }
    }
}
