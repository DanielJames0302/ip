package storage;

import command.*;
import exception.BuddyException;
import exception.BuddyInvalidCommandArgumentsException;
import exception.BuddyInvalidCommandException;
import exception.BuddyMissingCommandInfoException;

import java.util.ArrayList;

/**
 * Represent a parser for the input command
 *
 */
public class Parser {

    /**
     * Returns command type parsed from user input.
     *
     * @param userInput Command given by the user.
     * @return Command type parsed from user input.
     * @throws BuddyInvalidCommandException If the command is invalid.
     */
    public static Command parseCommand(String userInput) throws BuddyException {
            String command = userInput.split(" ")[0];
            String[] commandArgs = userInput.split(" ", 2);
            ArrayList<String> arguments = new ArrayList<>();

            try {
                switch (CommandType.valueOf(command.toUpperCase())) {
                case BYE:
                    return new ByeCommand();
                case LIST:
                    return new ListTasksCommand();
                case TODO:
                    arguments.add(commandArgs[1]);
                    return new AddTodoCommand(arguments);
                case DEADLINE:
                    String description = commandArgs[1].split(" /by ")[0];
                    String byTime = commandArgs[1].split(" /by ")[1];
                    arguments.add(description);
                    arguments.add(byTime);
                    return new AddDeadlineCommand(arguments);
                case EVENT:
                    String fromToTime = commandArgs[1].split(" /from ")[1];
                    arguments.add(commandArgs[1].split(" /from ")[0]);
                    arguments.add(fromToTime.split(" /to ")[0]);
                    arguments.add(fromToTime.split(" /to ")[1]);
                    return new AddEventCommand(arguments);
                case MARK:
                    arguments.add(commandArgs[1]);
                    return new MarkCommand(arguments);
                case UNMARK:
                    arguments.add(commandArgs[1]);
                    return new UnmarkCommand(arguments);
                case DELETE:
                    arguments.add(commandArgs[1]);
                    return new DeleteCommand(arguments);
                default:
                    throw new BuddyInvalidCommandArgumentsException("Invalid command arguments");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new BuddyMissingCommandInfoException(userInput);
            }

    }
}
