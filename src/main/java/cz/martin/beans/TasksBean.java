package cz.martin.beans;

import cz.martin.models.Task;
import cz.martin.services.TaskService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named("tasks")
@RequestScoped
public class TasksBean {

    @Inject
    private TaskService taskService;
    private String newTaskTitle = "";

    public void addNewTask() {
        this.taskService.newTask(newTaskTitle);
        this.newTaskTitle = "";
    }

    public void finishTask(Task task) {
        taskService.finishTask(task);
    }

    public void deleteTask(Task task) {
        taskService.deleteTask(task);
    }

    public List<Task> getActive() {
        return this.taskService.getActive();
    }

    public List<Task> getFinished() {
        return this.taskService.getFinished();
    }

    public String getNewTaskTitle() {
        return newTaskTitle;
    }

    public void setNewTaskTitle(String newTaskTitle) {
        this.newTaskTitle = newTaskTitle;
    }
}
