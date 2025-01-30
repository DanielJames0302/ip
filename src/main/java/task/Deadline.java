package task;

/**
 * Represents Deadline event
 *
 */
public class Deadline extends Task {
    protected String by;

    /**
     * Constructor for Deadline class.
     *
     * @param description Deadline task description.
     * @param by String representation of the deadline.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toStorageStringFormat() {
        String result = "D | ";
        result += this.isDone ? "1" : "0";
        result += " | " + this.description + " | ";
        result += this.by + "\n";
        return result;
    }

    /**
     * Retrieve string representation of deadline task.
     *
     * @return String representation of deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
