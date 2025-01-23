package exception;

public class BuddyInvalidCommandException extends BuddyException{
    private final String command;

    public BuddyInvalidCommandException(String userCommand) {
        this.command = userCommand;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(" Your command \"%s\" seems strange to me", this.command);
    }


}
