package TaskManager;

import static TaskManager.HelperClass.*;
import static Utils.TaskFile.*;
import static Utils.Colors.*;

public class TaskManager {
    static final String FILE_NAME = "tasks.csv";
    static String[][] todoList;

    public static void main(String[] args) {
        todoList = readAllLines(FILE_NAME);

        while (true) {
            showMenu();
            switch (readOption().toLowerCase()) {
                case "add" -> todoList = addTask(todoList);

                case "remove" -> {
                    int index = getTheNumber();
                    if(index < todoList.length) {
                        todoList = removeTask(todoList, index);
                        System.out.println("Value was successfully deleted.");
                    } else {
                        System.out.println("Value out of range.");
                    }
                }

                case "list" -> printArray(todoList);

                case "exit" -> {
                    saveToFile(FILE_NAME, todoList);
                    System.out.println(RED + "Bye, bye");
                    System.exit(0);
                }

                default -> System.out.println("Incorrect imput, please try again!");
            }
        }
    }


}
