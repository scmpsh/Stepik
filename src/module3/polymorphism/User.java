package module3.polymorphism;

public class User {

    private String login;

    public User(String login) {
        this.login = login;
    }

    public void callToAnotherUser(AbstractMessenger abstractMessenger) {
        System.out.print(abstractMessenger.getClass().toString().substring(27) + " | ");
        abstractMessenger.call();
    }

    public static void main(String[] args) {
        AbstractMessenger[] abstractMessengers = {
                new Telegram("1234"),
                new WhatsApp("4321"),
                new Viber("asda")
        };
        User user = new User("sudo");
        for (AbstractMessenger abstractMessenger : abstractMessengers) {
            user.callToAnotherUser(abstractMessenger);
        }
    }
}
