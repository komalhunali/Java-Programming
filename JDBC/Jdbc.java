package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_database";
        String username = "root";
        String password = "Root";
        String query = "SELECT * FROM employees";

        try {
            // Corrected class name to proper case
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
            return; // Exit if driver is not found
        }

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stat = con.createStatement();
             ResultSet rs = stat.executeQuery(query)) {

            System.out.println("Connection Established Successfully!!!");

            while (rs.next()) {
                // Corrected method calls to remove unnecessary columnLabel
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String jobTitle = rs.getString("job_title");
                double salary = rs.getDouble("salary");

                System.out.println();
                System.out.println("**********************");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Job Title: " + jobTitle);
                System.out.println("Salary: " + salary);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}


