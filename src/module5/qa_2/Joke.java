package module5.qa_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Joke {
    private static final String TEXT_OF_JOKE = """
            public class joke {
                public static void main(String[] args) {
                    System.out.println("Hello World!");
                }
            }""";
    private static final String JOKE_FILE = "/joke.java";

    public static void process(File dir) throws IOException {
//        System.out.println(dir + JOKE_FILE);
        FileWriter fileWriter = new FileWriter(dir + JOKE_FILE);
        fileWriter.write(TEXT_OF_JOKE);
        fileWriter.close();
    }

    public static void visitAllDirs(File dir) throws IOException {
        String[] childDirList = dir.list();
        if (childDirList != null) {
            for (String childDir : childDirList) {
                if ((new File(dir, childDir)).isDirectory()) {
                    process(new File(dir, childDir));
                }
                visitAllDirs(new File(dir, childDir));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Абсолютный путь до папки: ");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);
        visitAllDirs(dir);
    }
}
