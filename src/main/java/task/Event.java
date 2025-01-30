package task;

import command.Command;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents Event type
 *
 */
public class Event extends Task{
    protected LocalDateTime from;
    protected LocalDateTime to;

    /**
     * Constructor for Event class.
     *
     * @param description Description of the Event task.
     * @param from  Start time of the Event task.
     * @param to End time of the Event task.
     */
    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toStorageStringFormat() {
        String result = "E | ";
        result += this.isDone ? "1" : "0";
        result += " | " + this.description + " | ";
        result = result +  this.from.format(Task.storePattern) + " | " + this.to.format(Task.storePattern) + "\n";
        return result;
    }

    /**
     * Returns string representation of Event task.
     *
     * @return string representation of Event task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() +
                String.format(" (from: %s to: %s)", from.format(Task.writePattern), to.format(Task.writePattern));
    }
}
