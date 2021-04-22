package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.*;

public class E09_CopyAPicture {

    private static final String PICTURE_PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/creative-initiative.png";
    private static final String OUTPUT_PATH = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/output.png";

    public static void main(String[] args) throws IOException {

        try (FileInputStream fis = new FileInputStream(PICTURE_PATH);
             FileOutputStream fos = new FileOutputStream(OUTPUT_PATH)) {

            int oneByte = fis.read();

            while (oneByte != -1) {

                fos.write(oneByte);

                oneByte = fis.read();
            }

        }

    }
}
