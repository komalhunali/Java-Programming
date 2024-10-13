package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonDetails {
    private static final String URL = "jdbc:mysql://localhost:3306/my_database";
    private static final String USER = "root";
    private static final String PASSWORD = "Root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
             
            String query = "SELECT * FROM Person";  // Use uppercase for SQL keywords
            ResultSet resultSet = statement.executeQuery(query);
            
            // Print column headers
            System.out.printf("%-5s %-20s %-10s%n", "Pid", "Name", "Gender"); // Fixed formatting
            System.out.println("------------------------------"); // Improved line length
            
            // Print data
            while (resultSet.next()) {
                int pid = resultSet.getInt("Pid");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                System.out.printf("%-5d %-20s %-10s%n", pid, name, gender);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Exception handling
        }
    }
}

