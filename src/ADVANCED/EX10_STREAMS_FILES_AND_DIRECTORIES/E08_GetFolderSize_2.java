package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.File;

public class E08_GetFolderSize_2 {

    private static final String DIR_PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/Exercises Resources";
    private static final String OUTPUT_PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/output.txt";

    public static void main(String[] args) {

        File folder = new File(DIR_PATH);

        int folderSize = 0;
        for (File file : folder.listFiles()) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);

    }
}
