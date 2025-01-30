package buddy.command;

import buddy.display.Display;
import buddy.exception.BuddyException;
import buddy.storage.DataStorage;
import buddy.task.TaskList;

public class ByeCommand extends Command {

    public String execute(TaskList taskList, DataStorage dataStorage) throws BuddyException {
        this.isExit = true;
        return Display.bye();
    }
}
