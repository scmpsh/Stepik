package module5.Task_5_4_1;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static byte[] serializeAnimalArray(Object[] objects) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteStream);

        out.writeInt(objects.length);

        for (Object object : objects) {
            out.writeObject(object);
        }

        out.flush();
        return byteStream.toByteArray();
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int dataLength = objectInputStream.readInt();
            Animal[] animals = new Animal[dataLength];
            if (dataLength > 0) {
                for (int i = 0; i < dataLength; i++) {
                    animals[i] = (Animal) objectInputStream.readObject();
                }
            }
            return animals;
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Animal[] animals = new Animal[]{
                new Animal("Cat"),
                new Animal("Dog"),
                new Animal("Fox"),
        };
        Animal[] deserializeAnimals;
        byte[] serializeAnimals;

        serializeAnimals = serializeAnimalArray(animals);
        System.out.println("Serialize:      " + Arrays.toString(serializeAnimals));
        deserializeAnimals = deserializeAnimalArray(serializeAnimals);
        System.out.println("Deserialize:    " + Arrays.toString(deserializeAnimals));
    }
}
