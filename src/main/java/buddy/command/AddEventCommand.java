package buddy.command;

import java.time.LocalDateTime;
import java.util.ArrayList;

import buddy.display.Display;
import buddy.exception.BuddyException;
import buddy.exception.BuddyInvalidCommandArgumentsException;
import buddy.storage.DataStorage;
import buddy.task.Event;
import buddy.task.Task;
import buddy.task.TaskList;

/**
 * Represents The type Add event command.
 */
public class AddEventCommand extends Command {

    /**
     * Instantiates a new Add event command.
     *
     * @param args the args from the user command
     */
    public AddEventCommand(ArrayList<String> args) {
        super(args);
    }

    @Override
    public String execute(TaskList taskList, DataStorage dataStorage) throws BuddyException {
        try {
            LocalDateTime from = Command.getDateAndTime(args.get(1));
            LocalDateTime to = Command.getDateAndTime(args.get(2));
            Task task = new Event(args.get(0), from, to);
            taskList.addTask(task);
            dataStorage.saveTasksToStorage(taskList);
            return Display.addTask(task, taskList);
        } catch (IndexOutOfBoundsException error) {
            throw new BuddyInvalidCommandArgumentsException("Please enter event command in the"
                    + "following format \\`event [description] /from [dd/mm/yyyy HHmm] /to [dd/mm/yyyy HHmm]\\`");
        }
    }
}
