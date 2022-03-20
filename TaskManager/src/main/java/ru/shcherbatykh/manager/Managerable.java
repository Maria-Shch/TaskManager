package ru.shcherbatykh.manager;

import java.util.Date;
import java.util.List;

public interface Managerable {
    List<Task> getListTasks();
    
    boolean addTask(String title, String description, Date date);
    
    boolean removeTask(int indexTask);
    
    boolean isEmptyListTasks();
    
    boolean isPresentTaskByNumber(int numberOfTask);
}
