package task;

/**
 * Represents Task event
 *
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for Task class.
     *
     * @param description Description of a task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns string representation of the task status.
     *
     * @return string representation of the task status.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Mark the task as done.
     *
     */
    public void markTaskAsDone() {
        this.isDone = true;
    }

    /**
     * Mark the task as not done.
     *
     */
    public void unmarkTaskAsDone() {
        this.isDone = false;
    }

    public abstract String toStorageStringFormat();

    /**
     * Returns string representation of a task.
     *
     * @return String representation of a task.
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }
}
