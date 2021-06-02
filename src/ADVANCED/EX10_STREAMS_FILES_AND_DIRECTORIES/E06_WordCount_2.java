package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class E06_WordCount_2 {

    private static final String words = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/words.txt";
    private static final String text = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/text.txt";
    private static final String output = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/result.txt";

    public static void main(String[] args) throws IOException {

        PrintWriter writer = new PrintWriter(new FileWriter(output));
        LinkedHashMap<String, Integer> countWords = new LinkedHashMap<>();
        List<String> lines = Files.readAllLines(Path.of(words));

        for (String line : lines) {
            Arrays.stream(line.split("\\s+")).forEach(word -> countWords.put(word, 0));
        }

        for (String line : Files.readAllLines(Path.of(text))) {
            Arrays.stream(line.split("\\s+"))
                    .forEach(word -> {
                        if (countWords.containsKey(word)) {
                            countWords.put(word, countWords.get(word) + 1);
                        }
                    });
        }

        for (Map.Entry<String, Integer> word : countWords.entrySet()) {
            writer.println(word.getKey() + " - " + word.getValue());
        }

        writer.close();
    }
}
