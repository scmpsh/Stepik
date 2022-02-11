package dbService;

import dbService.dao.UserDAO;
import dbService.dao.UserDAOJDBC;
import dbService.dataSets.UserDataSet;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBServiceJDBC {
    private final Connection connection;
    private UserDAO userDAO;


    public DBServiceJDBC() {
        this.connection = getPSQLConnection();
        this.userDAO = new UserDAOJDBC(this.connection);
    }

    public UserDataSet getUser(long id) throws DBException {
        return (new UserDAOJDBC(connection).getWithId(id));
    }

    public Connection getConnection() {
        return connection;
    }

    public void printConnectInfo() {
        try {
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
            System.out.println("Autocommit: " + connection.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getPSQLConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("org.postgresql.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:postgresql://").   //db type
                    append("localhost:").           //host name
                    append("5432/").                //port
                    append("webdb?").               //db name
                    append("user=migalnikita&").    //login
                    append("password=");            //password

            System.out.println("URL: " + url + "\n");

            return DriverManager.getConnection(url.toString());
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
