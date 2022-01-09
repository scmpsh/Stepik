package module5.Task_5_2_2;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

//        try (Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII)) {
//            writer.write('ф');
//        }

//        byte[] code = "Ы".getBytes(StandardCharsets.UTF_8);
//        for (byte b : code) {
//            System.out.print(b & 0xff);
//        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[]{10, 10, 13, 10, 13});
        int prevByte = byteArrayInputStream.read();
//        int prevByte = System.in.read();
        final int END_OF_STREAM = -1;
        final int CARRIAGE_RETURN = 13;
        final int LINE_FEED = 10;
        int currentByte;
        if (prevByte != END_OF_STREAM) {
            while ((currentByte = byteArrayInputStream.read()) != END_OF_STREAM) {
                if (prevByte != CARRIAGE_RETURN || currentByte != LINE_FEED) {
                    System.out.write(prevByte);
                }
                prevByte = currentByte;
            }
        }
        if (prevByte != END_OF_STREAM) {
            System.out.write(prevByte);
        }
        System.out.flush();
    }
}
