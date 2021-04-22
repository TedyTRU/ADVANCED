package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class E06_WordCount {

    private static final String words = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/words.txt";
    private static final String text = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/text.txt";
    private static final String output = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/result.txt";

    public static void main(String[] args) {

        try (BufferedReader readerWords = new BufferedReader(new FileReader(words));
             BufferedReader readerText = new BufferedReader(new FileReader(text));
             PrintWriter writer = new PrintWriter(new FileWriter(output))) {

            String[] words = readerWords.readLine().split("\\s+");
            Map<String, Integer> mapOfWords = new HashMap<>();

            for (String word : words) {
                mapOfWords.put(word, 0);
            }

            String[] text = readerText.readLine().split("\\s+");

            for (String word : text) {
                if (mapOfWords.containsKey(word)) {
                    int countWords = mapOfWords.get(word);
                    mapOfWords.put(word, countWords + 1);
                }
            }

            mapOfWords.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(entry ->
                            writer.println(String.format("%s - %d", entry.getKey(), entry.getValue())));

        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
