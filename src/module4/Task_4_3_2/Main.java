package module4.Task_4_3_2;

import java.util.logging.*;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    /*
    Интерфейс: сущность, которую можно отправить по почте.
    У такой сущности можно получить от кого и кому направляется письмо.
    */
    public interface Sendable {
        String getFrom();

        String getTo();
    }

    /*
    Абстрактный класс,который позволяет абстрагировать логику хранения
    источника и получателя письма в соответствующих полях класса.
    */
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            return to.equals(that.to);
        }
    }

    /*
    Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
    */
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            return message != null ? message.equals(that.message) : that.message == null;
        }
    }

    /*
    Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            return content.equals(that.content);
        }
    }

    /*
    Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
    */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            return content.equals(aPackage.content);
        }
    }

    /*
    Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
    */
    public interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

    public static class UntrustworthyMailWorker implements MailService {
        private RealMailService realMailService;
        private MailService[] mailServices;

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
            realMailService = new RealMailService();
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (int i = 0; i < mailServices.length; i++) {
                mailServices[i].processMail(mail);
            }
            return realMailService.processMail(mail);
        }
    }

    public static class Spy implements MailService {
        Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                MailMessage mailMessage = (MailMessage) mail;
                if (mailMessage.getFrom().equals(AUSTIN_POWERS) || mailMessage.getTo().equals(AUSTIN_POWERS)) {
                    logger.warning("Detected target mail correspondence: from " + mailMessage.getFrom()
                            + " to " + mailMessage.getTo() + " \"" + mailMessage.getMessage() + "\"");
                } else {
                    logger.info("Usual correspondence: from " + mailMessage.getFrom()
                            + " to " + mailMessage.getTo());
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService {
        int minValue;
        static int stolenValue;

        public Thief(int minValue) {
            this.minValue = minValue;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                MailPackage mailPackage = (MailPackage) mail;
                if (mailPackage.getContent().getPrice() >= minValue) {
                    stolenValue += mailPackage.getContent().getPrice();
                    mailPackage = new MailPackage(mail.getFrom(), mail.getTo(),
                            new Package("stones instead of " + mailPackage.getContent().getContent(), 0));
                    mail = mailPackage;
                    return mail;
                }
            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {
        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {
        }
    }

    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                String content = ((MailPackage) mail).getContent().getContent();
                if (content.equals(WEAPONS)
                        || content.equals(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                } else if (content.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class.getName());

        AbstractSendable[] abstractSendable = {
                new MailMessage(AUSTIN_POWERS, WEAPONS, "Hi"),
                new MailMessage(AUSTIN_POWERS, AUSTIN_POWERS, "Oh its me mario"),
                new MailPackage(AUSTIN_POWERS, WEAPONS, new Package(BANNED_SUBSTANCE, 110)),
                new MailPackage(AUSTIN_POWERS, WEAPONS, new Package(WEAPONS, 110)),
        };

        MailService[] mailServices = {
                new Spy(logger),
                new Thief(300),
                new Inspector(),
        };

        UntrustworthyMailWorker untrustworthyMailWorker;
        System.out.println(ANSI_PURPLE + "UntrustworthyMailWorker" + ANSI_RESET);
        untrustworthyMailWorker = new UntrustworthyMailWorker(mailServices);
        for (AbstractSendable abstractSendable1 : abstractSendable) {
            untrustworthyMailWorker.processMail(abstractSendable1);
        }
//        System.out.println(untrustworthyMailWorker.getRealMailService());
    }
}
