package task;

import exception.BuddyException;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public int getLength() {
        return this.tasks.size();
    }

    public Task getTask(int index) {
        return this.tasks.get(index);
    }

    public void deleteTask(Task taskToDelete) {
        this.tasks = this.tasks.stream()
                .filter(task -> !task.equals(taskToDelete) )
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
