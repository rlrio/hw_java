package se.rlrio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOChamber {

    public static void main(String[] args) {
        printInput();
    }

    public static void printInput() {
        String fileName;
        try (BufferedReader readerForFileName = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = readerForFileName.readLine();
            Path path = Paths.get(fileName);
                if (Files.exists(path) && !Files.isDirectory(path)) {
                    printFromFile(path);
                } else {
                    System.out.println("Файл не распознан. Введите ваши сообщения");
                    printFromConsole();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void printFromFile(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            printOdd(lines.collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFromConsole() {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while (!(line = reader.readLine()).isEmpty()) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        printOdd(result);
    }

    private static void printOdd(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            if (i % 2 == 0) {
                System.out.println(lines.get(i));
            }
        }
    }
}

