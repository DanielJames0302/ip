package buddy.exception;

/**
 * Represents the type Buddy missing command info exception.
 */
public class BuddyMissingCommandInfoException extends BuddyException {
    private final String command;

    /**
     * Constructor for BuddyMissingCommandInfoException.
     *
     * @param command The command that don't have description.
     */
    public BuddyMissingCommandInfoException(String command) {
        this.command = command;
    }

    /**
     * Retrieve information string of the exception.
     *
     * @return information string of the exception.
     */
    @Override
    public String toString() {
        return super.toString()
                + String.format("Are you sure you have put all the information"
                + " in this command:\n%s", command);
    }
}
