package ru.shcherbatykh.manager;

import java.util.List;

public class Printer {
    public static void printListTask(List<Task> tasksList) {
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
