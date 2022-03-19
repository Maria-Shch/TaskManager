package ru.shcherbatykh.manager;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//вывод на консоль команд
//оповещение пользователя через swing, звук, запуск другой программы-оповещения
@Component
public class UserInterface {

    @Autowired
    Manager manager;

    private static final Scanner in = new Scanner(System.in).useDelimiter("\n");

    public void startMenu() {
        boolean flag = true;

        String menu = "1 - Вывести запланированные задачи\n"
                + "2 - Добавить задачу\n"
                + "3 - Удалить задачу\n"
                + "4 - Выйти\n";

        while (flag) {
            System.out.println(menu);
            System.out.println("Введите пункт меню:");
            int menuSelect = checkInt();

            switch (menuSelect) {
                case 1 -> {
                    Printer.printListTask(manager.getListTasks());
                }
                case 2 -> {
                    addingTask();
                }
                case 3 -> {
                    removingTask();
                }
                case 4 -> {
                    flag = false;
                    in.close();
                }
                default ->
                    System.out.println("Такой пункт в меню отсутвствует, попробуйте снова...\n");
            }
            if (flag) {
                waitActionFromUser();
            }
        }
    }

    private void addingTask() {
        System.out.println("Добавление задачи...");
        
        System.out.println("Введите название новой задачи:");
        String title = checkString();
        
        System.out.println("Введите описание новой задачи:");
        String description = checkString();
        
        System.out.println("Введите дату новой задачи:");
        String date = checkString();

        if (manager.addTask(new Task(title, description, date))) {
            System.out.println("Задача успешно добавлена");
        }
    }

    private void removingTask() {
        if (manager.isEmptyListTasks()) {
            System.out.println("Ваш список задач пуст, вы не можете ничего удалить.");
        } else {
            System.out.println("Удаление задачи...");
            System.out.println("Введите номер задачи:");
            int numberOfTask = checkInt();
            int indexOfTask = numberOfTask-1;
            if (manager.isPresentTaskByNumber(numberOfTask)) {
                if (manager.removeTask(indexOfTask)) {
                    System.out.println("Задача под номером " + numberOfTask + " успешно удалена.");
                } else {
                    System.out.println("Что-то пошло не так.");
                }
            } else {
                System.out.println("Задачи под таким номер не существует.");
            }
        }
    }

    private int checkInt() {
        int val;
        while (true) {
            if (in.hasNextInt()) {
                val = in.nextInt();
                break;
            } else {
                in.nextLine();
                System.out.println("Требуется значение типа int, попробуйте снова...");
            }
        }
        return val;
    }

    private float checkFloat() {
        float val = 0;
        while (true) {
            if (in.hasNextFloat()) {
                val = in.nextFloat();
            } else {
                in.nextLine();
                System.out.println("Требуется значение типа float, попробуйте снова...");
            }
            if (val != 0) {
                break;
            } else {
                in.nextLine();
                System.out.println("Требуется значение не равное нулю, попробуйте снова...");
            }
        }
        return val;
    }

    private String checkString() {
        String str;
        while (true) {
            if (in.hasNext()) {
                str = in.next();
                break;
            } else {
                in.nextLine();
                System.out.println("Требуется String значение, попробуйте снова...");
            }
        }
        return str;
    }

    private void waitActionFromUser() {
        System.out.println("Нажмите Enter чтобы продолжить...");
        in.next();
        in.nextLine();
    }
}
