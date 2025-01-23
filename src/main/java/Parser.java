public class Parser {
    public static Command parseInput(String userInput) {
        String command = userInput.split(" ")[0];
        return Command.valueOf(command.toUpperCase());
    }

    public static String parseCommandInfo(String userInput) {
        return userInput.split(" ", 2)[1];
    }
}
