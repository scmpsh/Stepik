package Core.module6.PECS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Class0> class0List = new ArrayList<>();
        class0List.add(new Class3());
        class0List.add(new Class2());
//        test(class0List);


//        List<Class2> class2List = new ArrayList<>();
//        class2List.add(new Class2());
//        class2List.add(new Class2());
//        test(class2List);
//
//        List<Class3> class3List = new ArrayList<>();
//        class3List.add(new Class3());
//        class3List.add(new Class3());
//        test(class3List);
    }

    private static void test(List<? extends Class1> list) {
        Object class0 = list.get(0); // return Object если ..CS
//        list.add(new Class2());
//        Class0 class2 = list.get(0);

        Iterator<? extends Class1> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Class1 classes : list) {
            System.out.println(classes.getClass().getSimpleName());
        }
    }
}
