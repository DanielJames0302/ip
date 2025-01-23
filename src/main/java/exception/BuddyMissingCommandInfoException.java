package exception;

public class BuddyMissingCommandInfoException extends BuddyException{
    private final String command;

    public BuddyMissingCommandInfoException(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(" You forgot to put in the " +
                "description of the command \"%s\"", command);
    }
}
