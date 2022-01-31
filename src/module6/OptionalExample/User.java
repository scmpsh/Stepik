package module6.OptionalExample;

import java.util.Optional;

public class User {

    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return this.age;
    }

    public static Optional<User> getAnAdultUser(User user) {
        return Optional.ofNullable(user).filter(t -> t.getAge() > 18);
    }

    public static void main(String[] args) {
        User user = new User("Nikita", 21);
        User user1 = null;
        System.out.println(getAnAdultUser(user1));
    }
}
