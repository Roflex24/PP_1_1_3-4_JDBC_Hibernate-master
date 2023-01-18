package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/Base?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    static Connection connection = null;
    static ResultSet resultSet = null;
    public static void getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено");
            }
        } catch (SQLException e) {
            System.out.println("Соединение с БД не установлено");
        }
    }

    public static void sendStatement(String command) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(command);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet sendStatementAll(String command) {
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(command);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}
