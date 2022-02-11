package Core.module3.polymorphism;

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
