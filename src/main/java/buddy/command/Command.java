package buddy.command;

import buddy.exception.BuddyException;
import buddy.storage.DataStorage;
import buddy.task.TaskList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Represents Command from the user
 *
 */
public abstract class Command {
    protected ArrayList<String> args;
    protected boolean isExit = false;
    private final static DateTimeFormatter storeDateTimePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Constructor for Command class
     *
     */
    public Command() {}

    /**
     * Constructor for Command class
     *
     * @param args Arguments from user command
     */
    public Command(ArrayList<String> args) {
        this.args = args;
    }

    public static LocalDateTime getDateAndTime(String input) throws DateTimeParseException, ArrayIndexOutOfBoundsException {
        String[] data = input.split(" ");
        LocalDate date = LocalDate.parse(data[0], storeDateTimePattern);
        String time = data[1];
        return date.atTime(Integer.parseInt(time.substring(0, 2)),
                Integer.parseInt(time.substring(2, 4)));
    }

    public boolean getExitStatus() {
        return isExit;
    }

    public abstract String execute(TaskList taskList, DataStorage dataStorage) throws BuddyException;
}
