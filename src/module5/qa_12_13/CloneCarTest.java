package module5.qa_12_13;

import java.io.*;

public class CloneCarTest {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        /*
         * Клонирование с помощью переопределения clone()
         */
        Car car = new Car("Грузовик", new Driver("Василий", 45));
        Car clonedCar = car.clone();
        System.out.println("Оригинал:\t" + car.getDriver().getName());
        System.out.println("Клон:   \t" + clonedCar.getDriver().getName());

        clonedCar.getDriver().setName("Вася");

        System.out.println("Оригинал после изменения имени водителя:\t" + car.getDriver().getName());
        System.out.println("Клон после изменения имени водителя:   \t\t" + clonedCar.getDriver().getName());

        System.out.println("**********************************************");
        /*
         * Клонирование с помощью конструктора копирования
         */
        Car carCnstrct = new Car("Грузовик", new Driver("Василий", 45));
        Car clonedCarCnstrct = new Car(carCnstrct);
        System.out.println("Оригинал:\t" + carCnstrct.getDriver().getName());
        System.out.println("Клон:   \t" + clonedCarCnstrct.getDriver().getName());

        clonedCarCnstrct.getDriver().setName("Вася");

        System.out.println("Оригинал после изменения имени водителя:\t" + carCnstrct.getDriver().getName());
        System.out.println("Клон после изменения имени водителя:   \t\t" + clonedCarCnstrct.getDriver().getName());

        System.out.println("**********************************************");
        /*
         * Клонирование с помощью сериализации
         */
        Car carSerial = new Car("Грузовик", new Driver("Василий", 45));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        ous.writeObject(carSerial);
        ous.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Car clonedCarSerial = (Car) ois.readObject();
        System.out.println("Оригинал:\t" + carSerial.getDriver().getName());
        System.out.println("Клон:   \t" + clonedCarSerial.getDriver().getName());

        clonedCarCnstrct.getDriver().setName("Вася");

        System.out.println("Оригинал после изменения имени водителя:\t" + carCnstrct.getDriver().getName());
        System.out.println("Клон после изменения имени водителя:   \t\t" + clonedCarCnstrct.getDriver().getName());
    }
}
