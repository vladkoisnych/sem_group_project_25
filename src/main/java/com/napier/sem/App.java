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


        //report 15
        ArrayList<Country> countries15 = a.report15();
        System.out.println("Report 15 size: " + countries15.size());

        // Display results



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
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * * getCity function
     * * getting a city by id,
     * * created for testing purposes while implementing sql connection
     * * @param id - city id
     * */
    public City getCity(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, Population "
                            + "FROM city "
                            + "WHERE ID = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            if (rset.next())
            {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.city_population = rset.getInt("Population");
                System.out.println("Got city" + city.city_id + " " + city.city_name);
                return city;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }


    /**
     * * displayCity function
     * * printing the details of a chosen city,
     * * created for testing purposes while implementing sql connection
     * * @param city - city object
     * */
    public void displayCity(City city)
    {
        if (city != null)
        {
            System.out.println(
                    city.city_id + " "
                    + city.city_name + "\n"
                    + city.city_population + "\n");
        }else System.out.println("City is empty");
    }

    public ArrayList<Country> report15()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Population "
                            + "FROM country "
                            + "WHERE continent = 'europe' "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<Country>();

            //populate the array
            while (rset.next())
            {
                Country country = new Country();
                country.country_code = rset.getString("Code");
                country.country_name = rset.getString("Name");
                country.country_population = rset.getInt("Population");

                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country list. Report 15");
            return null;
        }
    }

}
