package exception;

public class BuddyTaskNotFoundException extends BuddyException {
    private final int taskListSize;

    /**
     * Constructor for BuddyTaskNotFoundException
     *
     * @param taskListSize current length of the task list.
     */
    public BuddyTaskNotFoundException(int taskListSize) {
        this.taskListSize = taskListSize;
    }

    /**
     * Retrieve information string of the exception
     *
     * @return information string of the exception.
     */
    @Override
    public String toString() {
        return super.toString() +
                String.format(" Your task id is invalid since the " +
                        "current length of task list is %s", this.taskListSize);
    }
}
