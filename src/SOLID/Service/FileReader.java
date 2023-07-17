package SOLID.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface FileReader {
    default List<String> readFile(Object fileName) {
        List<String> records = new ArrayList<>();
        if (fileName instanceof String) {
            try (Scanner scanner = new Scanner(new File((String) fileName));) {
                while (scanner.hasNextLine()) {
                    records.add(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return records;
    }
}
