package task;

import exception.BuddyException;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;

/**
 * Represents task list
 *
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructor for TaskList class.
     *
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Add new task to current task list.
     *
     * @param task The new task.
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Returns the size of task list.
     *
     * @return The size of task list.
     */
    public int getLength() {
        return this.tasks.size();
    }

    /**
     * Returns task indicated by index.
     *
     * @param index Task index in the task list.
     * @return Task indicated by index.
     */
    public Task getTask(int index) {
        return this.tasks.get(index);
    }

    /**
     * Deletes taskToDelete in the task list
     *
     * @param taskToDelete Task that needs to be deleted.
     */
    public void deleteTask(Task taskToDelete) {
        this.tasks = this.tasks.stream()
                .filter(task -> !task.equals(taskToDelete) )
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
