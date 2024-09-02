package org.example.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteExample {

    // SQLite connection string
    private static final String URL = "jdbc:sqlite:test.db"; // Replace with your database file path

    public static void main(String[] args) {
        try {
            // Step 1: Connect to the database
            Connection conn = connect();

            // Step 2: Create the 'users' table if it doesn't exist
            createTable(conn);

            // Step 3: Insert a new user
            insertUser(conn, "Alice", 30);
            insertUser(conn, "Bob", 25);

            // Step 4: Query and display the users
            selectAllUsers(conn);

            // Close the connection
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Connect to the SQLite database
     * @return Connection object
     */
    private static Connection connect() {
        Connection conn = null;
        try {
            // Establish a connection to the SQLite database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Create the 'users' table
     * @param conn Connection object
     */
    private static void createTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "age INTEGER" +
                ");";

        try (Statement stmt = conn.createStatement()) {
            // Execute the SQL statement
            stmt.execute(sql);
            System.out.println("Table 'users' created.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Insert a new user into the 'users' table
     * @param conn Connection object
     * @param name Name of the user
     * @param age Age of the user
     */
    private static void insertUser(Connection conn, String name, int age) {
        String sql = "INSERT INTO users (name, age) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set the values for the query
            pstmt.setString(1, name);
            pstmt.setInt(2, age);

            // Execute the insert statement
            pstmt.executeUpdate();
            System.out.println("User " + name + " inserted.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Select and display all users
     * @param conn Connection object
     */
    private static void selectAllUsers(Connection conn) {
        String sql = "SELECT id, name, age FROM users";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Loop through the result set and print the users
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Name: " + rs.getString("name") +
                        " | Age: " + rs.getInt("age"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
