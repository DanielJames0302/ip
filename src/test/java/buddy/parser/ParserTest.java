package buddy.parser;

import buddy.exception.BuddyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {

    /**
     * Test if invalid input to the parse method will throws BuddyException or not.
     */
    @Test
    public void invalidOutput_shouldThrowDukeException() {
        Exception exception = assertThrows(BuddyException.class, () -> {
            Parser.parseCommand("Kaka borrow book");
        });

        String expectedMessage = "Attention !! Your command \"Kaka borrow book\" seems strange to me";
        String actualMessage = exception.toString();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}