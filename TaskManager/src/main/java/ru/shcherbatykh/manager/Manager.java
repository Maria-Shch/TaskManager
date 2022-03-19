package ru.shcherbatykh.manager;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
/*
Планировщик задач состоит из 
журнала задач, 
пользовательского интерфейса для добавления и удаления задачи, а также 
системы оповещения пользователя о каком-то событии, т.е. в назаначенное 
в планировщике время должно происходить нечто, говорящее пользователю о том, 
что у него запланирована некоторая задача
    добавление задачи
    удаление задачи (после того как пользователь или удалил или завершил её)
    отложить задачу 
    сохранение на диск в виде XML
*/

@Component
public class Manager {
    private List<Task> listTasks = new ArrayList<>();

    public List<Task> getListTasks() {
        return listTasks;
    }
    
    public boolean addTask(Task task){
        return listTasks.add(task);
    }
    
    public boolean removeTask(int indexTask){
        return listTasks.remove(indexTask) != null;
    }
    
    public boolean isEmptyListTasks(){
        return listTasks.isEmpty();
    }
    
    public boolean isPresentTaskByNumber(int numberOfTask){
        return numberOfTask <= listTasks.size() && numberOfTask > 0;
    }
}
