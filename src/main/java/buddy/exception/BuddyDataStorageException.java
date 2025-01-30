package buddy.exception;

public class BuddyDataStorageException extends BuddyException {

    /**
     * Constructor for BuddyDataStorageException.
     *
     * @param message message string for exception.
     */
    public BuddyDataStorageException(String message) {
        super(message);
    }

    /**
     * Retrieve information string of the exception.
     *
     * @return information string of the exception.
     */
    @Override
    public String toString() {
        return super.toString() + " " + this.message;
    }
}
