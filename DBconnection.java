package Librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root"; // your username
    private static final String PASS = "Sanjay123"; // your password

    public static Connection getConnection() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e ) {
            e.printStackTrace();
            return null;
        }
    }
}