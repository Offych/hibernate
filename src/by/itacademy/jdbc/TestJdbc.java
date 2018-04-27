package by.itacademy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";

        try {
            System.out.println("Conectting to database: " + url);
            Connection myConn = DriverManager.getConnection(url, user, password);

            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
