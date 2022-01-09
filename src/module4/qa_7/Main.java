package module4.qa_7;

import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static class IOManip implements Closeable {
        @Override
        public void close() {
            throw new RuntimeException("from IOManip.close");
        }
    }

    public static void checkClose() /*throws IOException*/ {

//        FileReader reader = new FileReader("notes3.txt");
//
//        int c;
//        while ((c = reader.read()) != -1) {
//
//            System.out.print((char) c);
//        }

        try (IOManip ioManip = new IOManip()) {
            throw new RuntimeException("from try!");
        } catch (RuntimeException e) {
            for (Throwable throwable : e.getSuppressed()) {
                System.err.println("suppressed " + throwable + "\n");
            }
            RuntimeException runtimeException = new RuntimeException();
            runtimeException.addSuppressed(e);
            throw new RuntimeException("from catch!");
        }
//        finally {
//            throw new RuntimeException("from finally");
//        }
    }

    public static void main(String[] args) {
        checkClose();

//        try {
//            checkClose();
//        } catch (IOException e) {
//            System.out.println("IOException");;
//        }
    }
}
