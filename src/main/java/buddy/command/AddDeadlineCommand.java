package buddy.command;

import buddy.display.Display;
import buddy.exception.BuddyException;
import buddy.exception.BuddyInvalidCommandArgumentsException;
import buddy.storage.DataStorage;
import buddy.task.Deadline;
import buddy.task.Task;
import buddy.task.TaskList;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class AddDeadlineCommand extends Command {

    public AddDeadlineCommand(ArrayList<String> args) {
        super(args);
    }




    @Override
    public String execute(TaskList taskList, DataStorage dataStorage) throws BuddyException {
        try {
            LocalDateTime by = getDateAndTime(args.get(1));
            Task task = new Deadline(args.get(0), by);
            taskList.addTask(task);
            dataStorage.saveTasksToStorage(taskList);
            return Display.addTask(task, taskList);
        } catch(IndexOutOfBoundsException error) {
            throw new BuddyInvalidCommandArgumentsException("Please enter deadline command in the" +
                    "following format \\`deadline [description] /by [dd/mm/yyyy HHmm]\\`");
        }
    }
}
