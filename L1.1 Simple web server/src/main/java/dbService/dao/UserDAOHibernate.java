package dbService.dao;

import dbService.dataSets.UserDataSet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;

public class UserDAOHibernate implements UserDAO {

    private Session session;

    public UserDAOHibernate(Session session) {
        this.session = session;
    }

    @Override
    public UserDataSet getWithId(long id) {
        return (UserDataSet) session.get(UserDataSet.class, id);
    }

    @Override
    public UserDataSet getWithLogin(String name) {
        Criteria criteria = session.createCriteria(UserDataSet.class);
        return ((UserDataSet) criteria.add(Restrictions.eq("login", name)).uniqueResult());
    }

    @Override
    public long getUserId(String name) throws SQLException {
        try {
            Criteria criteria = session.createCriteria(UserDataSet.class);
            return ((UserDataSet) criteria.add(Restrictions.eq("login", name)).uniqueResult()).getId();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    @Override
    public long insertUser(String name, String password) throws SQLException {
        return (Long) session.save(new UserDataSet(name, password));
    }

    @Override
    public void createTable() throws SQLException {

    }

    @Override
    public void dropTable() throws SQLException {

    }
}
