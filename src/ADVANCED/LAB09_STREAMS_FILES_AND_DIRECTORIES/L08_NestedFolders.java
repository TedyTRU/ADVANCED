package ADVANCED.LAB09_STREAMS_FILES_AND_DIRECTORIES;

import java.io.File;
import java.io.IOException;

public class L08_NestedFolders {

    public static int foldersCount = 0;

    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Users\\Teodora\\My Thingy\\JAVA\\ADVANCED\\04.STREAMS, FILES AND DIRECTORIES\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(fileName);

        dfs(file);

        System.out.println(foldersCount + " folders");
    }

    public static void dfs(File file) {
        // Bottom-case
        // Step

        foldersCount++;
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                dfs(f);
            }
        }
        System.out.println(file.getName());
    }
}
