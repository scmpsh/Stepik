package Core.module3.polymorphism;

public class WhatsApp extends AbstractMessenger {

    public WhatsApp(String login) {
        super(login);
    }

    @Override
    protected Telegram call() {
        System.out.println("Пытаюсь по видеосвязи объяснить бабушке как оплатить свет через приложение банка");
        return null;
    }
}
