package buddy;

import buddy.command.Command;
import buddy.display.Display;
import buddy.parser.Parser;
import buddy.storage.DataStorage;
import buddy.task.TaskList;
import buddy.exception.BuddyException;

/**
 * Represents Buddy chatbot
 *
 */
public class Buddy {
    private TaskList taskList;
    private Display display;
    private boolean isRunning;
    private DataStorage dataStorage;

    /**
     * Constructor for Buddy class.
     *
     */
    public Buddy() {
        this.isRunning = true;
        this.display = new Display();
        this.dataStorage = new DataStorage("./data/buddy.txt");
        try {
            this.taskList = new TaskList(this.dataStorage.loadData());
        } catch (BuddyException e) {
            System.out.println(Display.showError(e));
            this.taskList = new TaskList();
        }
    }

    /**
     * Start the Buddy chatbot.
     *
     */
    private void start() {
        System.out.println(Display.greet());
        boolean isBye = false;
        while(!isBye) {
            String userInput = this.display.readInput();
            try {
                Command command = Parser.parseCommand(userInput);
                isBye = command.getExitStatus();
                System.out.println(command.execute(taskList, dataStorage));
            } catch (BuddyException error) {
                System.out.println(Display.showError(error));
            }
        }
        this.display.closeInput();
    }


    public static void main(String[] args) {
        new Buddy().start();
    }
}
