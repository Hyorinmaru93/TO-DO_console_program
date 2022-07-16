package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TaskFile {
    public static String[][] readAllLines(String fileName) {
        Path dirrectory = Paths.get(fileName);

        if (!Files.exists(dirrectory)) {
            System.out.println("File not exist");
            System.exit(0);
        }

        String[][] todoList = null;
        try {
            List<String> temporaryList = Files.readAllLines(dirrectory);
            todoList = new String[temporaryList.size()][temporaryList.get(0).split(",").length];

            for (int i = 0; i < temporaryList.size(); i++) {
                String[] split = temporaryList.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    todoList[i][j] = split[j];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return todoList;
    }

    public static void saveToFile(String fileName, String[][] todoList) {
        Path dirrectory = Paths.get(fileName);

        String[] lines = new String [todoList.length];
        for (int i = 0; i < todoList.length; i++) {
            lines[i] = String.join(",",todoList[i]);
        }

        try{
            Files.write(dirrectory, Arrays.asList(lines));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
