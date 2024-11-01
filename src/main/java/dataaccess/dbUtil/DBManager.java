package dataaccess.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private final static String HOST_NAME = "db";
	private final static String DATABASE_NAME = "database";
	private final static String USER_NAME = "root";
	private final static String PASSWORD = "root";
	private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final static String DRIVER_URL = "jdbc:mysql://" + HOST_NAME + ":3306/" + DATABASE_NAME + "?useUnicode=true&characterEncoding=utf-8";

    private static Connection connection;

    public static Connection getConnection() {
        try {
			Class.forName(DRIVER_NAME);
			Connection connection = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
			return connection;
		} catch (ClassNotFoundException e) {
			System.out.println("Can't Find JDBC Driver.\n");
		} catch (SQLException e) {
			System.out.println("Connection Error.\n");
		}
		return null;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}