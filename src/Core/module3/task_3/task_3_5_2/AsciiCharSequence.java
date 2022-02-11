package Core.module3.task_3.task_3_5_2;

public class AsciiCharSequence implements CharSequence {
    byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) (bytes[index]);
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        byte[] result = new byte[end - start];

        for (int i = 0; start < end; i++) {
            result[i] = bytes[start];
            start++;
        }
        return new AsciiCharSequence(result);
    }

    public AsciiCharSequence subSequence(int start) {
        return subSequence(start, bytes.length - 1);
    }

    public AsciiCharSequence delete(int from, int to) {

        byte[] result = new byte[bytes.length - (to - from + 1)];
        int i;

        i = 0;
        while (i < from) {
            result[i] = bytes[i];
            i++;
        }
        while (to != bytes.length - 1) {
            result[i] = bytes[to + 1];
            to++;
            i++;
        }
        return new AsciiCharSequence(result);
    }

    @Override
    public String toString() {
        return new String(bytes);
    }

    public static void main(String[] args) {

        byte[] bytes = {'I', 'l', 'i', 'k', 'e', 'd', 'o', 'g', 's'};
        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(bytes);

        System.out.println(asciiCharSequence.subSequence(5));
        System.out.println(asciiCharSequence.delete(1, 4));
        System.out.println(asciiCharSequence);
    }
}
