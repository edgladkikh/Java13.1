package org.example;

public class Epic extends Task {
    protected String[] subtask;

    public Epic(int id, String[] subtask) {
        super(id);
        this.subtask = subtask;
    }

    @Override
    public boolean matches(String query) {
        for (String subtask : subtask) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
