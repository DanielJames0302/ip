package buddy.command;

import buddy.display.Display;
import buddy.exception.BuddyException;
import buddy.storage.DataStorage;
import buddy.task.Task;
import buddy.task.TaskList;
import buddy.task.Todo;


import java.util.ArrayList;

public class AddTodoCommand extends Command {
    public AddTodoCommand(ArrayList<String> args) {
        super(args);
    }

    @Override
    public String execute(TaskList taskList, DataStorage dataStorage) throws BuddyException {
        Task task = new Todo(args.get(0));
        taskList.addTask(task);
        dataStorage.saveTasksToStorage(taskList);
        return Display.addTask(task, taskList);
    }
}
