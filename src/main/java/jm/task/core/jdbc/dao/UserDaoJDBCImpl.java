package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Util.sendStatement("CREATE TABLE IF NOT EXISTS users " + "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), last_name VARCHAR(255), age INT)");
    }

    public void dropUsersTable() {
        Util.sendStatement("DROP TABLE IF EXISTS users");
    }

    public void saveUser(String name, String lastName, byte age) {
        Util.sendStatement("INSERT INTO users (name, last_name, age) VALUES ('" + name + "', '" + lastName + "', " + age + ")");
    }

    public void removeUserById(long id) {
        Util.sendStatement("DELETE FROM users WHERE id = " + id);
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = Util.sendStatementAll("SELECT * FROM users");
        while (resultSet.next()) {
            User user = new User(resultSet.getString("name"),
                    resultSet.getString("last_name"),
                    resultSet.getByte("age"));
            user.setId(resultSet.getLong("id"));
            users.add(user);
        }
        return users;
    }

    public void cleanUsersTable() {
        Util.sendStatement("TRUNCATE TABLE users");
    }
}
