package task;

/**
 * Represents Event type
 *
 */
public class Event extends Task{
    protected String from;
    protected String to;

    /**
     * Constructor for Event class.
     *
     * @param description Description of the Event task.
     * @param from  Start time of the Event task.
     * @param to End time of the Event task.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns string representation of Event task.
     *
     * @return string representation of Event task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() +
                String.format(" (from: %s to: %s)", from, to);
    }
}
