//package accounts;
//
//import dbService.DBException;
//import dbService.dao.UserDAOJDBC;
//import dbService.dataSets.UserDataSet;
//import main.Main;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Класс для управления аккаунтами.
// * @author migalnikita
// */
//public class AccountService {
//
//    UserDAOJDBC userDAOJDBC;
//    private final Connection connection;
//    /**
//     * Поле карта с парой ключ:значение (логин пользователя:объект <b>UserProfile</b>)
//     */
//    private final Map<String, UserProfile> loginToProfile;
//    /**
//     * Поле карта с парой ключ:значение (id сессии:объект <b>UserProfile</b>)
//     */
//    private final Map<String, UserProfile> sessionIdToProfile;
//
//    /**
//     * Конструктор - создание нового объекта
//     * @param connection
//     */
//    public AccountService(Connection connection) {
//        userDAOJDBC = new UserDAOJDBC(connection);
//        this.connection = connection;
//        loginToProfile = new HashMap<>();
//        sessionIdToProfile = new HashMap<>();
//    }
//
//    /**
//     * Метод добавления нового пользователя в карту <b>loginToProfile</b>
//     */
//    public long addNewUser(UserProfile userProfile) throws DBException {
//        long id = Main.dbServiceJDBC.addUser(userProfile.getLogin(), userProfile.getPassword());
//        System.out.println("User with id = " + id + " added!");
//        UserDataSet userDataSet = Main.dbServiceJDBC.getUser(id);
//        System.out.println("User data set: " + userDataSet);
//        return id;
//    }
//
//    /**
//     * Метод получения значения из карты <b>loginToProfile</b> по логину
//     * @return <b>UserProfile</b>
//     */
//    public long getUserByLogin(String login) {
//        try {
//            return userDAOJDBC.getUserId(login);
//        } catch (SQLException e) {
//            return 0;
//        }
//    }
//
//    public UserDataSet getUsersDataSet(long id) throws DBException {
//        return Main.dbServiceJDBC.getUser(id);
//    }
//
//    /**
//     * Метод получения значения из карты <b>sessionIdToProfile</b> по id сессии
//     * @return <b>UserProfile</b>
//     */
//    public UserProfile getUserBySessionId(String sessionId) {
//        return sessionIdToProfile.get(sessionId);
//    }
//
//    /**
//     * Метод добавления новой сессии в карту <b>sessionIdToProfile</b>
//     */
//    public void addSession(String sessionId, UserProfile userProfile) {
//        sessionIdToProfile.put(sessionId, userProfile);
//    }
//
//    /**
//     * Метод удаления сессии и пользователя из карты <b>sessionIdToProfile</b> и
//     * <b>loginToProfile</b>
//     */
//    public void deleteSession(String sessionId) {
//        loginToProfile.remove(sessionIdToProfile.get(sessionId).getLogin());
//        sessionIdToProfile.remove(sessionId);
//    }
//}
