package com.napier.sem;
import java.sql.*;
import java.util.ArrayList;

/**
 * Main Class
 */
public class App {
    /**
     * * Main function
     * * @param args
     * */
    public static void main(String[] args) {
        //actual code goes here
        System.out.println("MySQL Connection");

        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // report 17
        ArrayList<Country> countries17 = a.report17();
        System.out.println("Report 17 size: " + countries17.size());



        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Report 17: Get the top N populated countries in the world.
     * @return ArrayList of top N populated countries
     */
    public ArrayList<Country> report17() {
        try {
            // Set N to a specific value for the number of top populated countries
            int N = 10; // Example: Top 10 countries

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Population " +
                            "FROM country " +
                            "ORDER BY Population DESC " +
                            "LIMIT " + N;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();

            // Populate the array
            while (rset.next()) {
                Country country = new Country();
                country.country_code = rset.getString("Code");
                country.country_name = rset.getString("Name");
                country.country_population = rset.getInt("Population");

                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country list. Report 17");
            return null;
        }
    }
}
