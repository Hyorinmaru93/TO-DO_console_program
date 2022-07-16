package TaskMenager;

import static TaskMenager.HelperClass.*;
import static Utils.TaskFile.*;
import static Utils.Colors.*;

public class TaskMenager {
    static final String FILE_NAME = "tasks.csv";
    static String[][] todoList;

    public static void main(String[] args) {
        todoList = readAllLines(FILE_NAME);

        while (true) {
            showMenu();
            switch (readOption().toLowerCase()) {
                case "add" -> todoList = addTask(todoList);

                case "remove" -> System.out.println("Usuń");

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
