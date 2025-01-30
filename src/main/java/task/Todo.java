package task;

/**
 * Represents Todo event
 *
 */
public class Todo extends Task {
    protected String by;

    /**
     * Constructor for Todo class.
     *
     * @param description Description of todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns String representation of todo task in storage.
     *
     * @return String representation of todo task in storage.
     */
    @Override
    public String toStorageStringFormat() {
        String result = "T | ";
        result += this.isDone ? "1" : "0";
        result += " | " + this.description + "\n";
        return result;
    }

    /**
     * Returns String representation of todo task.
     *
     * @return String representation of todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
