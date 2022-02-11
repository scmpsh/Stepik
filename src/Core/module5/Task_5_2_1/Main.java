package Core.module5.Task_5_2_1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        final int EOS = -1;
        int checksum = 0;
        int readByte;

        while ((readByte = inputStream.read()) != EOS) {
            checksum = Integer.rotateLeft(checksum, 1) ^ readByte;
        }
        return checksum;
    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream;
        int result;

        inputStream = new ByteArrayInputStream(new byte[]{0x33, 0x45, 0x01});
        result = checkSumOfStream(inputStream);
        System.out.println(result);
    }

}
