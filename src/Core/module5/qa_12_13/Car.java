package Core.module5.qa_12_13;

import java.io.Serializable;

public class Car implements Cloneable, Serializable {
    private String name;
    private Driver driver;
    private Driver passanger;

    public void setPassanger(Driver passanger) {
        this.passanger = passanger;
    }

    public Driver getPassanger() {
        return passanger;
    }

    public Car(String name, Driver driver) {
        this.name = name;
        this.driver = driver;
    }

    /*
     * Конструктор копирования поверхностный.
     */
//    public Car(Car otherCar) {
//        this(otherCar.getName(), otherCar.getDriver());
//    }

    /*
     * Глубокое копирование
     */
    public Car(Car otherCar) {
        this(otherCar.getName(), new Driver(otherCar.getDriver().getName(), otherCar.getDriver().getAge()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

//    @Override
//    public Car clone() throws CloneNotSupportedException {
//        return (Car) super.clone();
//    }

    /*
     * глубокое с помощью переопределения
     */
    @Override
    public Car clone() throws CloneNotSupportedException {
        Car newCar = (Car) super.clone();
        Driver driver = this.getDriver().clone();
        newCar.setDriver(driver);
        return newCar;
    }
}
