package Core.module3.polymorphism;

public class Telegram extends AbstractMessenger {

    public Telegram(String login) {
        super(login);
    }

    @Override
    protected Viber call() {
        System.out.println("Позвоню другу по видеосвязи");
        return null;
    }
}
