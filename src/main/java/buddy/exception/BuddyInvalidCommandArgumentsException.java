package buddy.exception;

public class BuddyInvalidCommandArgumentsException extends BuddyException{

    public BuddyInvalidCommandArgumentsException(String message) {
        super(message);
    }


    /**
     * Retrieve information string of the exception.
     *
     * @return information String of the exception.
     */
    @Override
    public String toString() {
        return super.toString() + this.message;
    }
}
