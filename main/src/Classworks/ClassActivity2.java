package Classworks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ClassActivity2 {

    public static void main(String[] args) throws IOException {
        Path p = Paths.get("main/src/Classworks", "test.txt");

        try {
            List<String> lines = Files.readAllLines(p);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Path output = Paths.get("main/src/Classworks", "output.txt");

        List<String> lines2 = List.of("Hello", "How are you?", "Thanks");

        try {
            Files.write(output, lines2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
