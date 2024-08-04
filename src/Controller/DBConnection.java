package Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static final String CONFIG_FILE = "src/config.properties";
    private String DB_URL;
    private String USER;
    private String PASS;
    Connection conn;

    DBConnection() {
        loadConfig();
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadConfig() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(CONFIG_FILE)) {
            properties.load(input);
            DB_URL = properties.getProperty("DB_URL");
            USER = properties.getProperty("DB_USER");
            PASS = properties.getProperty("DB_PASS");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }
}