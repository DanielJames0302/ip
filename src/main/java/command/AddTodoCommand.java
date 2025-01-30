package command;

import display.Display;
import exception.BuddyException;
import storage.DataStorage;
import task.Task;
import task.TaskList;
import task.Todo;


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
