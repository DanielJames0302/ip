package exception;

public class BuddyInvalidCommandArgumentsException extends BuddyException{

    /**
     * Retrieve information string of the exception.
     *
     * @return information String of the exception.
     */
    @Override
    public String toString() {
        return super.toString() + " It seems like you entered an invalid arguments";
    }
}
