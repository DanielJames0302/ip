import exception.BuddyException;
import exception.BuddyInvalidCommandException;
import exception.BuddyMissingCommandInfoException;

/**
 * Represent a parser for the input command
 *
 */
public class Parser {

    /**
     * Returns command type parsed from user input.
     *
     * @param userInput Command given by the user.
     * @return command type parsed from user input.
     * @throws BuddyInvalidCommandException If the command is invalid.
     */
    public static Command parseInput(String userInput) throws BuddyException {
        try {
            String command = userInput.split(" ")[0];
            return Command.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BuddyInvalidCommandException(userInput);
        }

    }

    /**
     * Returns Task description parsed from user input.
     *
     * @param userInput Command given by the user.
     * @return Task description parsed from user input.
     * @throws BuddyMissingCommandInfoException If the task description is missing.
     */
    public static String parseCommandInfo(String userInput) throws BuddyException {
        try {
            return userInput.split(" ", 2)[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new BuddyMissingCommandInfoException(userInput);
        }
    }
}
