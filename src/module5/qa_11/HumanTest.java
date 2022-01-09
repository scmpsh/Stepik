package module5.qa_11;

import java.io.*;
import java.util.Arrays;

public class HumanTest {

    private static byte[] serializeArray(Object[] objects) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(baos)) {
            out.writeInt(objects.length);
            for (Object object : objects) {
                out.writeObject(object);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Human[] deserializeArray(byte[] data) {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int dataLength = ois.readInt();
            Human[] humans = new Human[dataLength];
            for (int i = 0; i < dataLength; i++) {
                humans[i] = (Human) ois.readObject();
            }
            return humans;
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) {
        Human[] human = {
                new Human("Adam", "1789"),
                new Human("Eva", "9871")
        };
        byte[] serialBytes;
        Human[] deserialHumans;

        System.out.println("\n**********ENCRYPT************\n");
        serialBytes = serializeArray(human);
        System.out.println("\n**********DECRYPT************\n");
        deserialHumans = deserializeArray(serialBytes);
        System.out.println("\n**********RESULT************\n");
        System.out.println("SERIALIZE: " + Arrays.toString(serialBytes));
        System.out.println("DESERIALIZE: " + Arrays.toString(deserialHumans));
    }
}
