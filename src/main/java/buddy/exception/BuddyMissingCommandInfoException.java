package buddy.exception;

public class BuddyMissingCommandInfoException extends BuddyException{
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
                + String.format(" You forgot to put in the " +
                "description of the command \"%s\"", command);
    }
}
