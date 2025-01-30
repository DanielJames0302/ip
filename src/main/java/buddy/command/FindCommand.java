package buddy.command;

import buddy.display.Display;
import buddy.exception.BuddyException;
import buddy.exception.BuddyInvalidCommandArgumentsException;
import buddy.exception.BuddyTaskNotFoundException;
import buddy.storage.DataStorage;
import buddy.task.Task;
import buddy.task.TaskList;

import java.util.ArrayList;

public class FindCommand extends Command {

    public FindCommand(ArrayList<String> args) {
        super(args);
    }

    public String execute(TaskList taskList, DataStorage dataStorage) throws BuddyException {
        if (taskList.getLength() == 0) {
            return "You have no task in your list.\n";
        }

        System.out.println(args.get(0));
        TaskList filteredList = taskList.filter(args.get(0));
        if (filteredList.getLength() == 0) {
            return "No tasks found based on your keyword.\n";
        }

        return Display.filterTask(filteredList);
    }
}
