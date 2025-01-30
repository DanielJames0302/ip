package parser;

import command.*;
import exception.BuddyException;
import exception.BuddyInvalidCommandException;

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
        ArrayList<String> args = new ArrayList<>();
        try {
            switch (CommandType.valueOf(command.toUpperCase())) {
            case BYE:
                return new ByeCommand();
            case LIST:
                return new ListTasksCommand();
            case TODO:
                args.add(commandArgs[0]);
                return new AddTodoCommand(args);
            case DEADLINE:
                String byTime = commandArgs[1].split(" /by ")[1];
                args.add(commandArgs[1].split(" /by ")[0]);
                args.add(byTime);
                return new AddDeadlineCommand(args);
            case EVENT:
                String fromToTime = commandArgs[1].split(" /from ")[1];
                String fromTime = fromToTime.split(" /to ")[0];
                String toTime = fromToTime.split(" /to ")[1];
                args.add(commandArgs[1].split(" /by ")[0]);
                args.add(fromTime);
                args.add(toTime);
                return new AddEventCommand(args);
            case MARK:
                args.add(commandArgs[0]);
                return new MarkCommand(args);
            case UNMARK:
                args.add(commandArgs[0]);
                return new UnmarkCommand(args);
            case DELETE:
                args.add(commandArgs[0]);
                return new DeleteCommand(args);
            default:
                throw new BuddyInvalidCommandException(userInput);
            }
        } catch (IllegalArgumentException e) {
            throw new BuddyInvalidCommandException(userInput);
        }
    }
}
