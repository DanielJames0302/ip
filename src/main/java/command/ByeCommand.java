package command;

import display.Display;
import exception.BuddyException;
import storage.DataStorage;
import task.TaskList;

public class ByeCommand extends Command {

    public String execute(TaskList taskList, DataStorage dataStorage) throws BuddyException {
        this.isExit = true;
        return Display.bye();
    }
}
