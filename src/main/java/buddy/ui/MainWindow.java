package buddy.ui;

import buddy.Buddy;
import buddy.display.Display;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Buddy buddy;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image buddyImage = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /**
     * Injects the Duke instance
     */
    public void setDuke(Buddy buddy) {
        this.buddy = buddy;

        String taskList = this.buddy.getResponse("list");

        dialogContainer.getChildren().addAll(
                DialogBox.getBuddyDialog(taskList, buddyImage)
        );
    }

    /**
     * Send greet message.
     */
    public void sendGreetMessage() {
        dialogContainer.getChildren().addAll(
                DialogBox.getBuddyDialog(Display.greet(), buddyImage)
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = buddy.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getBuddyDialog(response, buddyImage)
        );
        userInput.clear();
    }
}

