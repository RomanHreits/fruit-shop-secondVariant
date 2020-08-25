package temporary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class FileExecutor {
    private static final String INPUT_HEAD = "type,fruit,quantity,date";
    private static final String OUTPUT_HEAD = "fruit,quantity\n";

    public List<String> fileExecutor(String filePath) {
        checkPath(filePath);
        Path path = Paths.get(filePath);
        try {
            List<String> strings = Files.readAllLines(path);
            if(strings.get(0).equals(INPUT_HEAD)) {
                strings.remove(0);
                return strings;
            }
            throw new IllegalArgumentException("Incorrect file structure!");
        } catch (IOException e) {
            throw new NoSuchElementException("File not found, filePath is wrong");
        }
    }

    public List<String> createInfoFile(Map<String, FruitStorage> storageMap, String filePath) {
        Path path = Paths.get(filePath);
        checkPath(filePath);
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
            return writerToFile(storageMap, path);
        } catch (IOException e) {
           throw new RuntimeException("Something went wrong!!!");
        }
    }

    private List<String> writerToFile(Map<String, FruitStorage> storageMap, Path path) throws IOException {
        Files.writeString(path, OUTPUT_HEAD);
        List<String> reportStrings = new ArrayList<>();
        reportStrings.add(OUTPUT_HEAD);
        for (Map.Entry<String, FruitStorage> entry : storageMap.entrySet()) {
            int sum = entry.getValue().getStorage().values().stream().mapToInt(Integer::intValue).sum();
            String format = String.format("%s, %d\n", entry.getKey(), sum);
            Files.writeString(path, format, StandardOpenOption.APPEND);
            reportStrings.add(format);
        }
        return reportStrings;
    }

    private void checkPath(String filepath) {
        if (filepath.isEmpty()) {
            throw new IllegalArgumentException("Invalid parameter filepath!");
        }
    }
}
