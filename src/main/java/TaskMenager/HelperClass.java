package TaskMenager;

import Utils.Colors;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.validator.GenericValidator;

import java.util.Arrays;
import java.util.Scanner;

public class HelperClass {
    public static void showMenu() {
        System.out.println(Colors.BLUE + "Please select an option:" + Colors.RESET);
        System.out.println("add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("exit");
    }

    public static String readOption() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice;
    }

    public static String[][] addTask(String[][] arrayTODO) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please add task description");
        String description = scanner.nextLine();

        System.out.println("Please add task due date (YYYY-MM-DD)");
        String dueDate = readCorrectDate();

        System.out.println("Is your task important: true/false");
        String isImportant = scanner.nextLine();

        arrayTODO = Arrays.copyOf(arrayTODO, arrayTODO.length + 1);
        arrayTODO[arrayTODO.length - 1] = new String[3];
        arrayTODO[arrayTODO.length - 1][0] = description;
        arrayTODO[arrayTODO.length - 1][1] = dueDate;
        arrayTODO[arrayTODO.length - 1][2] = isImportant;

        return arrayTODO;
    }

    private static String readCorrectDate() {
        GenericValidator genericValidator = new GenericValidator();
        Scanner scanner = new Scanner(System.in);
        String dueDate;
        boolean incorrectDateFormat = false;
        do {
            if (incorrectDateFormat) {
                System.out.println("Please type a date in correct format! (YYYY-MM-DD)");
            }
            dueDate = scanner.nextLine();
            if (!genericValidator.isDate(dueDate, "yyyy-MM-dd", true)) {
                incorrectDateFormat = true;
            }
        } while (!genericValidator.isDate(dueDate, "yyyy-MM-dd", true));
        return dueDate;
    }

    public static void printArray(String[][] arrayTODO) {
        for (int i = 0; i < arrayTODO.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < arrayTODO[i].length; j++) {
                if (arrayTODO[i][2].equals("true")) {
                    System.out.print(Colors.YELLOW + arrayTODO[i][j] + " " + Colors.RESET);
                } else {
                    System.out.print(arrayTODO[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static String[][] removeTask(String[][] tab, int index) {
        try {
            if (index < tab.length) {
                tab = ArrayUtils.remove(tab, index);
                return tab;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Element not exist in tab");
        } finally {
            return tab;
        }
    }

    private static boolean isNumberGreaterEqualZero(String input) {
        if (NumberUtils.isParsable(input)) {
            return Integer.parseInt(input) >= 0;
        }
        return false;
    }

    public static int getTheNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select number to remove.");

        String n = scanner.nextLine();
        while (!isNumberGreaterEqualZero(n)) {
            System.out.println("Incorrect argument passed. Please give number greater or equal 0");
            n = scanner.nextLine();
        }
        return Integer.parseInt(n);
    }


}
