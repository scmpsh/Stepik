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
        String encryptData;
        int[] numbersFromData = toIntArray(data.toCharArray());
        int encryptNum = 0;
        int currentNum;
        int nextNum;
        for (int i = 0; i < numbersFromData.length; i++) {
            if (i + 1 == numbersFromData.length) {
                currentNum = numbersFromData[i];
                nextNum = numbersFromData[0];
                encryptNum += (currentNum + nextNum) % 10;
            } else {
                currentNum = numbersFromData[i];
                nextNum = numbersFromData[i + 1];
                encryptNum += (currentNum + nextNum) % 10;
                encryptNum *= 10;
            }
        }
        encryptData = String.valueOf(encryptNum);
        System.out.println("After encrypt: " + encryptData);
        return encryptData;
    }

    private String decryptString(String data) {
        System.out.println("Before decrypt: " + data);
        String decryptData;
        int[] numbers = toIntArray(data.toCharArray());
        int currentNum;
        int prevNum;
        int decryptNum = 0;
        int numbersLength = numbers.length - 1;

        for (int i = numbersLength; i >= 0; i--) {
            if (numbers[i] == 0 && i == numbersLength) {
                numbers[i] = numbers[0] + 1;
            } else if (i == numbersLength) {
                numbers[i] = Math.abs(numbers[i] - numbers[0]);
            } else {
                currentNum = (numbers[i] + 10);
                prevNum = numbers[i + 1];
                numbers[i] = (currentNum - prevNum) % 10;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            decryptNum += numbers[i];
            if (i != numbersLength) {
                decryptNum *= 10;
            }
        }
        decryptData = String.valueOf(decryptNum);
        System.out.println("After decrypt: " + decryptData);
        return decryptData;
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
