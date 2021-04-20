package ADVANCED.LAB09_STREAMS_FILES_AND_DIRECTORIES;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L05_WriteEveryThirdLine_2 {
    public static void main(String[] args) throws IOException {

        String fileName = "input.txt";

        List<String> strings = Files.readAllLines(Path.of(fileName));
        List<String> lines = new ArrayList<>();

        for (int i = 2; i < strings.size(); i += 3) {
            lines.add(strings.get(i));
        }

//            Files.write(Path.of("out.txt"),
//                    Collections.singleton(strings.get(i)),
//                    StandardCharsets.UTF_8);

        Files.write(Path.of("out.txt"),
                lines, StandardCharsets.UTF_8);

    }
}
