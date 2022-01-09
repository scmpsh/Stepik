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

    private String encryptString(String data) {
        System.out.println("Before encrypt: " + data);
        String encryptData;
        char[] charsOfData = data.toCharArray();
        int encryptNum = 0;
        for (int i = 0; i < charsOfData.length - 1; i++) {
            int currentNum = Integer.parseInt(String.valueOf(charsOfData[i]));
            int nextNum = Integer.parseInt(String.valueOf(charsOfData[i + 1]));
            encryptNum += (currentNum + nextNum) % 10;
            encryptNum *= 10;
        }
        encryptData = String.valueOf(encryptNum);
        System.out.println("After encrypt: " + encryptData);
        return encryptData;
    }

    private String decryptString(String data) {
        System.out.println("Before decrypt: " + data);
        String decryptData;
        char[] charsOfData = data.toCharArray();
        int decryptNum = 0;
        for (int i = 0; i < charsOfData.length - 1; i++) {
            int currentNum = Integer.parseInt(String.valueOf(charsOfData[i]));
            int nextNum = Integer.parseInt(String.valueOf(charsOfData[i + 1]));
            decryptNum += (currentNum + nextNum) % 10;
            decryptNum *= 10;
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
