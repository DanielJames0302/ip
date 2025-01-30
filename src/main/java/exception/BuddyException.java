package exception;

public abstract class BuddyException extends Exception {
    protected String message = "";

    public BuddyException(String message) {
        this.message = message;
    }

    public BuddyException() {}

    /**
     * Retrieve information string of the exception.
     *
     * @return information string of the exception.
     */
    @Override
    public String toString() {
        return "Attention !!";
    }
}
