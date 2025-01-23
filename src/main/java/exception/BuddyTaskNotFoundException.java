package exception;

public class BuddyTaskNotFoundException extends BuddyException {
    private final int taskListSize;

    public BuddyTaskNotFoundException(int taskListSize) {
        this.taskListSize = taskListSize;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(" Your task id is invalid since the " +
                        "current length of task list is %s", this.taskListSize);
    }
}
