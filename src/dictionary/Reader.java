package dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public static void main(String[] args) {
        String filePath = "src/dictionary/dictionary.txt";
        
        if (doesFileExist(filePath)) {
            readAndPrintFile(filePath);
        } else {
            System.out.println("File does not exist at the given path.");
        }
    }

    public static boolean doesFileExist(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static void readAndPrintFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" - ");
                String word = parts[0];
                String[] meanings = parts[1].split(", ");

                System.out.println(word);
                for (String meaning : meanings) {
                    System.out.println(meaning);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
