package exception;

public class BuddyInvalidCommandArgumentsException extends BuddyException{

    @Override
    public String toString() {
        return super.toString() + " It seems like you entered an invalid task id";
    }
}
