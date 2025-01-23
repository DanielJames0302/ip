package exception;

public abstract class BuddyException extends Exception {

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
