package module5.qa_11;

import java.io.*;

public class Human implements Externalizable {
    String name;
    String passportNumber;

    public Human(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public Human() {
    }

    private int[] toIntArray(char[] data) {
        int[] resultArray = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            resultArray[i] = Integer.parseInt(String.valueOf(data[i]));
        }
        return resultArray;
    }

    private String encryptString(String data) {
        System.out.println("Before encrypt: " + data);
        int[] intArray = toIntArray(data.toCharArray());
        StringBuilder encryptData = new StringBuilder();

        for (int i = 0; i < intArray.length - 1; i++) {
            int currentNum = intArray[i];
            int nextNum = intArray[i + 1];
            encryptData.append((currentNum + nextNum) % 10);
        }
        encryptData.append(intArray[intArray.length - 1]);
        System.out.println("After encrypt: " + encryptData + "\n");
        return String.valueOf(encryptData);
    }

    private String decryptString(String data) {
        System.out.println("Before decrypt: " + data);
        int[] intArray = toIntArray(data.toCharArray());
        StringBuilder decryptData = new StringBuilder();
        int currentNum;
        int prevNum;
        int intArrayLength = intArray.length - 1;

        for (int i = intArrayLength; i > 0; i--) {
            currentNum = intArray[i - 1] + 10;
            prevNum = intArray[i];
            intArray[i - 1] = Math.abs(prevNum - currentNum) % 10;
        }
        for (int number : intArray) {
            decryptData.append(number);
        }
        System.out.println("After decrypt: " + decryptData + "\n");
        return String.valueOf(decryptData);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.name);
        out.writeObject(this.encryptString(this.passportNumber));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        passportNumber = this.decryptString((String) in.readObject());

    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
