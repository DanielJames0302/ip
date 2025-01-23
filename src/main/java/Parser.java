import exception.BuddyException;
import exception.BuddyInvalidCommandException;
import exception.BuddyMissingCommandInfoException;

public class Parser {
    public static Command parseInput(String userInput) throws BuddyException {
        try {
            String command = userInput.split(" ")[0];
            return Command.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BuddyInvalidCommandException(userInput);
        }

    }

    public static String parseCommandInfo(String userInput) throws BuddyException {
        try {
            return userInput.split(" ", 2)[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new BuddyMissingCommandInfoException(userInput);
        }
    }
}
