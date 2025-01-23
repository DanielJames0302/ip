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
     * @param description description of todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns string representation of todo task.
     *
     * @return string representation of todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
