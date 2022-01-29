package module6.GenericsExample;

public class Main {

    public static void main(String[] args) {
        Integer integer = 10;
        String text = "some text";

//         пример на Objects

        ObjectExample objectExample = new ObjectExample(integer, text);
//        String getLeft = (String) objectExample.getLeft(); // я ошибся, а оно компилируется и программа падает в рантайме

//         пример на Generics

        GenericsExample<Integer, String> genericsExample = new GenericsExample<>(integer, text);
//        String getLeft1 = genericsExample.getLeft();  // не дает скомпилировать ошибочный тип
        Integer getLeftInt = genericsExample.getLeft();
    }
}
