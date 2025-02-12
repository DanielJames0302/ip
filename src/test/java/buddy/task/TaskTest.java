package buddy.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <h1>TaskTest Class</h1>
 * Test for the Task class.
 */
public class TaskTest {

    @Test
    public void initialiseShouldReturnEmptyStringForStatus() {
        Task task = new Todo("Test");
        Assertions.assertEquals(" ", task.getStatusIcon());
    }


    @Test
    public void markTaskAsDone_shouldReturnXForStatus() {
        Task task = new Todo("Test");
        task.markTaskAsDone();
        Assertions.assertEquals("X", task.getStatusIcon());
    }


    @Test
    public void toString_shouldGiveCorrectFormat() {
        Task task = new Todo("Test");
        String expected = "[T][ ] Test";
        Assertions.assertEquals(expected, task.toString());
    }
}
