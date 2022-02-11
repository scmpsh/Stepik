package Core.module5.Task_5_3_1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[5];
        int read;
        while ((read = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, read);
        }
        return byteArrayOutputStream.toString(charset);
    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[]{48, 49, 50, 51, 49, 54});
        System.out.println(readAsString(inputStream, StandardCharsets.US_ASCII));
    }
}
