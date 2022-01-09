package module3.polymorphism;

import module4.Task_4_3_2.Main;

public abstract class AbstractMessenger {

    private String login;

    public AbstractMessenger(String login) {
        this.login = login;
    }

    protected AbstractMessenger call() {
        System.out.println("чето както");
        return null;
    }
}
