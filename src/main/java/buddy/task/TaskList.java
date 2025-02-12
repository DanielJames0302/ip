package buddy.task;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Represents task list
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructor for TaskList class.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
        assert this.tasks != null : "Task list should be initialized";
    }

    /**
     * Instantiates a new Task list.
     *
     * @param tasks the tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        assert tasks != null : "Task list parameter should not be null";
        this.tasks = tasks;
    }

    /**
     * Add new task to current task list.
     *
     * @param task The new task.
     */
    public void addTask(Task task) {
        assert task != null : "Cannot add a null task";
        int oldSize = this.tasks.size();

        this.tasks.add(task);

        assert this.tasks.size() == oldSize + 1 : "Task list size should increase by 1 after adding a task";
    }

    /**
     * Returns the size of task list.
     *
     * @return The size of task list.
     */
    public int getLength() {
        assert this.tasks != null : "Task list should not be null when getting length";
        return this.tasks.size();
    }

    /**
     * Returns task indicated by index.
     *
     * @param index Task index in the task list.
     * @return Task indicated by index.
     */
    public Task getTask(int index) {
        assert index >= 0 && index < this.tasks.size() : "Index out of bounds in getTask()";
        return this.tasks.get(index);
    }

    /**
     * Deletes taskToDelete in the task list
     *
     * @param taskToDelete Task that needs to be deleted.
     */
    public void deleteTask(Task taskToDelete) {
        assert taskToDelete != null : "Cannot delete a null task";
        int oldSize = this.tasks.size();

        this.tasks = this.tasks.stream()
                .filter(task -> !task.equals(taskToDelete))
                .collect(Collectors.toCollection(ArrayList::new));

        assert this.tasks.size() <= oldSize : "Task list size should not increase after deletion";
    }

    /**
     * Filter task list.
     *
     * @param keyword the keyword
     * @return the task list
     */
    public TaskList filter(String keyword) {
        assert this.tasks != null : "Task list should not be null before filtering";
        assert keyword != null : "Keyword should not be null";

        ArrayList<Task> filteredTasks = this.tasks.stream()
                .filter(t -> t.getDescription() != null && t.getDescription().contains(keyword))
                .collect(Collectors.toCollection(ArrayList::new));

        assert filteredTasks.size() <= this.tasks.size() : "Filtered task list cannot be larger than original list";
        return new TaskList(filteredTasks);
    }
}
