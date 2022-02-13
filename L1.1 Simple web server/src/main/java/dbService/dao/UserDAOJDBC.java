package dbService.dao;

import dbService.dataSets.UserDataSet;
import dbService.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAOJDBC implements UserDAO {

    private Executor executor;

    public UserDAOJDBC(Connection connection) {
        this.executor = new Executor(connection);
    }

    @Override
    public UserDataSet getWithId(long id) {
        try {
            return executor.execQuery("select * from users where id=" + id, result -> {
                result.next();
                return new UserDataSet(result.getLong(1), result.getString(2),
                        result.getString(3));
            });
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public UserDataSet getWithLogin(String name) {
        try {
            return executor.execQuery("select * from users where login='" + name + "'", result -> {
                result.next();
                return new UserDataSet(result.getLong(1), result.getString(2),
                        result.getString(3));
            });
        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public long getUserId(String name) {
        try {
            return executor.execQuery("select * from users where login='" + name + "'", result -> {
                result.next();
                return result.getLong(1);
            });
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public long insertUser(String name, String password) throws SQLException {
        executor.execUpdate("insert into users (login, password) values ('" + name + "', '" + password + "');");
        return 1;
    }
}
