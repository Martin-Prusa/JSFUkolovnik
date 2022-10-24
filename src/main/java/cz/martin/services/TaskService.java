package cz.martin.services;

import cz.martin.models.Task;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class TaskService implements Serializable {
    private List<Task> tasks = new ArrayList<>();


    public void newTask(String title) {
        this.tasks.add(new Task(title));
    }

    public void finishTask(Task task) {
        task.finish();
    }

    public void deleteTask(Task task) {
        this.tasks.remove(task);
    }
    private List<Task> getFilteredTasks(boolean isActive) {
        return this.tasks.stream().filter(i -> i.isActive() == isActive).toList();
    }

    public List<Task> getActive() {
        return getFilteredTasks(true);
    }

    public List<Task> getFinished() {
        return getFilteredTasks(false);
    }
}
