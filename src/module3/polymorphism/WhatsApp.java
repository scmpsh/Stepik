package module3.polymorphism;

import java.util.SortedMap;

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
