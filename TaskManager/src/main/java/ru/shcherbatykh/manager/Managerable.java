package ru.shcherbatykh.manager;

import java.util.List;

public interface Managerable {
    List<Task> getListTasks();
    
    boolean addTask(String title, String description, String date);
    
    boolean removeTask(int indexTask);
    
    boolean isEmptyListTasks();
    
    boolean isPresentTaskByNumber(int numberOfTask);
}
