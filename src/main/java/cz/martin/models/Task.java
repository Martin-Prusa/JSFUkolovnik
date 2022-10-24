package cz.martin.models;

public class Task {
    private String title;
    private boolean isActive;

    public Task(String title) {
        this.title = title;
        this.isActive = true;
    }

    public void finish() {
        this.isActive = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isActive() {
        return isActive;
    }
}
