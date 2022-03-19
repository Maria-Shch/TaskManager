package ru.shcherbatykh.manager;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class Printer implements Printable{
    @Override
    public void printListTask(List<Task> tasksList) {
        if (tasksList.isEmpty()) System.out.println("У вас нет ни одной задачи");
        else {
            int number = 1;
            for (int i = 0; i < tasksList.size(); i++) {
                System.out.println(number + ". " + tasksList.get(i).toString());
                number++;
            }
        }
    }
}
