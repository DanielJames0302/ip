package task;

import exception.BuddyException;
import exception.BuddyInvalidCommandArgumentsException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents Deadline event
 *
 */
public class Deadline extends Task {
    protected LocalDateTime by;

    /**
     * Constructor for Deadline class.
     *
     * @param description Deadline task description.
     * @param dueDate String representation of the deadline.
     */
    public Deadline(String description, LocalDateTime dueDate) throws BuddyException {
        super(description);

        try {
            this.by = dueDate;
        } catch (DateTimeParseException e) {
            throw new BuddyInvalidCommandArgumentsException("Please enter valid deadline task in the following format "
                    + "deadline [description] /by [yyyy-mm-dd] format.");
        }
    }

    @Override
    public String toStorageStringFormat() {
        String result = "D | ";
        result += this.isDone ? "1" : "0";
        result += " | " + this.description + " | ";
        result += this.by.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm")) + "\n";
        return result;
    }

    /**
     * Retrieve string representation of deadline task.
     *
     * @return String representation of deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm a")) + ")";
    }
}
