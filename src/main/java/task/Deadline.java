package task;

public class Deadline extends Task {
    protected String by;

    /**
     * Constructor for Deadline class.
     *
     * @param description deadline task description.
     * @param by string representation of the deadline.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Retrieve string representation of deadline task.
     *
     * @return string representation of deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
