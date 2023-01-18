package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Ivan", "Ivanov", (byte) 20);
        userDao.saveUser("Vlad", "Vladov", (byte) 25);
        userDao.saveUser("Petr", "Petrov", (byte) 31);
        userDao.saveUser("Danil", "Danilov", (byte) 38);

        userDao.removeUserById(1);
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
