package module3.polymorphism;

public class Viber extends AbstractMessenger {

    public Viber(String login) {
        super(login);
    }

    @Override
    protected Viber call() {
        super.call();
        return null;
    }
}
