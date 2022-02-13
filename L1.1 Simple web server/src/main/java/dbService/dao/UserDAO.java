package dbService.dao;

import dbService.dataSets.UserDataSet;

import java.sql.SQLException;

public interface UserDAO {
    UserDataSet getWithId(long id);
    UserDataSet getWithLogin(String name);
    long getUserId(String name) throws SQLException;
    long insertUser(String name, String password) throws SQLException;
}
