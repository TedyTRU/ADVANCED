package ADVANCED.LAB09_STREAMS_FILES_AND_DIRECTORIES;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class L06_SortLines {
    public static void main(String[] args) throws IOException {
        String fileName = "input.txt";

//        List<String> lines = Files.readAllLines(Paths.get(fileName))
//                .stream()
//                .sorted(String::compareTo)
//                .collect(Collectors.toList());
//
//        Files.write(Paths.get("out.txt"), lines, Charset.defaultCharset());


        File file = new File(fileName);

        List<String> lines = Files.readAllLines(file.toPath())
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Files.write(Paths.get("out.txt"), lines, Charset.defaultCharset());


    }
}
