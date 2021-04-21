package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class E04_CountCharacterTypes {

    private static final String INPUT_PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/input.txt";
    private static final String OUTPUT_PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/output.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_PATH))) {

            Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
            Set<Character> punctuationMarks = Set.of('!', '?', '.', ',');

            String line = reader.readLine();
            int vowelsCount = 0;
            int punctuationMarksCount = 0;
            int consonantsCount = 0;

            while (line != null) {

                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    if (vowels.contains(symbol)) {
                        vowelsCount++;
                    } else if (punctuationMarks.contains(symbol)) {
                        punctuationMarksCount++;
                    } else if (symbol != ' ') {
                        consonantsCount++;
                    }
                }

                line = reader.readLine();
            }

            writer.println(String.format("Vowels: %d", vowelsCount));
            writer.println(String.format("Consonants: %d", consonantsCount));
            writer.println(String.format("Punctuation: %d", punctuationMarksCount));

        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
