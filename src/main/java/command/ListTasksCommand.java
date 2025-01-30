package command;

import display.Display;
import exception.BuddyException;
import storage.DataStorage;
import task.TaskList;

public class ListTasksCommand extends Command {

    @Override
    public String execute(TaskList taskList, DataStorage dataStorage) throws BuddyException {
        return Display.listTasks(taskList);
    }
}
