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
        if (args.length < 1) {
            a.connect("localhost:33060", 10000);
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        //release version
        System.out.println("Release 0.1.0.3");

        //report 14
        ArrayList<Country> countries14 = a.report14();
        System.out.println("Report 14 size: " + countries14.size());

        //report 15
        ArrayList<Country> countries15 = a.report15();
        System.out.println("Report 15 size: " + countries15.size());

        //report 16
        ArrayList<Country> countries16 = a.report16();
        System.out.println("Report 16 size: " + countries16.size());

        //report 17
        ArrayList<Country> countries17 = a.report17(10);
        System.out.println("Report 17 size: " + countries17.size());

        // report 18
        String continent = "Europe"; // Specify the continent
        int N = 10; // Specify the top N countries
        ArrayList<Country> countries18 = a.report18(continent, N);
        System.out.println("Report 18 size: " + countries18.size());

        // report 19
        String region = "Western Europe"; // Specify the region
        N = 5; // Specify the top N countries
        ArrayList<Country> countries19 = a.report19(region, N);
        System.out.println("Report 19 size: " + countries19.size());

        // report 21
        ArrayList<City> cities21 = a.report21();
        System.out.println("Report 21 size: " + cities21.size());

        // report 30
        ArrayList<City> cities30 = a.report30();
        System.out.println("Report 30 size: " + cities30.size());

        // report 31
        continent = "Europe"; // Specify the continent
        ArrayList<City> cities31 = a.report31(continent);
        System.out.println("Report 31 size: " + cities31.size());

        // report 61
        ArrayList<Country> countries61 = a.report61();
        System.out.println("Report 61 size: " + countries61.size());

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
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 3;
        boolean shouldWait = false;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                if (shouldWait) {
                    // Wait a bit for db to start
                    Thread.sleep(delay);
                }

                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());

                // Let's wait before attempting to reconnect
                shouldWait = true;
            } catch (InterruptedException ie) {
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
    public static void displayCity(City city)
    {
        if (city != null)
        {
            System.out.println(
                    city.city_id + " "
                    + city.city_name + "\n"
                    + city.city_population + "\n");
        }else System.out.println("City is empty");
    }

    /**
     * * printCountryList function
     * * printing the details of a country list,
     * * created for testing purposes while implementing unit testing
     * * @param countries - array list filled with countries
     * */
    public static void printCountryList(ArrayList<Country> countries)
    {
        if (countries == null){
            System.out.println("No countries");
            return;
        }


        if (!countries.isEmpty()) {
            for (Country country : countries) {

                if (country == null) continue;

                String countryStr = new String();
                countryStr += "Code: " + country.country_code + "\n";
                countryStr += "Name: " + country.country_name + "\n";
                countryStr += "Population: " + country.country_population;
                System.out.println(countryStr);
            }
        }else System.out.println("Country list is empty");
    }

    /**
     * * report14 function
     * * returning all the countries in the world organised by largest population to smallest,
     * * created for report 14.
     * */
    public ArrayList<Country> report14()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Population "
                            + "FROM country "
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
            System.out.println("Failed to get country list. Report 14");
            return null;
        }
    }




    /**
     * * report15 function
     * * returning all the countries in a continent organised by largest population to smallest,
     * * created for report 15.
     * */

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

    /**
     * * report16 function
     * * returning all the countries in a region organised by largest population to smallest,
     * * created for report 16.
     * */

    public ArrayList<Country> report16()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Population "
                            + "FROM country "
                            + "WHERE region = 'Western Europe' "
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
            System.out.println("Failed to get country list. Report 16");
            return null;
        }
    }

    /**
     * * report17 function
     * * returning the top N populated countries in the world, where N is provided by the user
     * * created for report 17.
     * * @param n - n populated countries in the world, is provided by the user
     * */

    public ArrayList<Country> report17(int n) {
        try {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Population " +
                            "FROM country " +
                            "ORDER BY Population DESC " +
                            "LIMIT " + n;
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

    /**
     * * report18 function
     * * returning the top N populated countries in the continent, where N is provided by the user
     * * created for report 18.
     * * @param continent - continent, is provided by the user
     * * @param n - n populated countries in the continent, is provided by the user
     * */
    public ArrayList<Country> report18(String continent, int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Population " +
                            "FROM country " +
                            "WHERE continent = '" + continent + "' " +
                            "ORDER BY Population DESC " +
                            "LIMIT " + n;
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
            System.out.println("Failed to get country list. Report 18");
            return null;
        }
    }

    /**
     * * report19 function
     * * returning the top N populated countries in the region, where N is provided by the user
     * * created for report 19.
     * * @param region - continent, is provided by the user
     * * @param n - n populated countries in the region, is provided by the user
     * */
    public ArrayList<Country> report19(String region, int n) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Population " +
                            "FROM country " +
                            "WHERE region = '" + region + "' " +
                            "ORDER BY Population DESC " +
                            "LIMIT " + n;
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
            System.out.println("Failed to get country list. Report 19");
            return null;
        }
    }


    /**
     * * report21 function
     * * returning all the cities in a continent organized by largest population to smallest,
     * * created for Report 21.
     * */
    public ArrayList<City> report21() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM country " +
                            "JOIN city ON Code = city.CountryCode " +
                            "WHERE continent = 'europe' " +
                            "ORDER BY city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();

            // Populate the array
            while (rset.next()) {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.city_population = rset.getInt("Population");

                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city list. Report 21");
            return null;
        }
    }

    /**
     * * report30 function
     * * returning all the capital cities in the world organized by largest population to smallest,
     * * created for Report 30
     * */
    public ArrayList<City> report30() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM country " +
                            "JOIN city ON Code = city.CountryCode " +
                            "WHERE city.ID = Capital " +
                            "ORDER BY city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();

            // Populate the array
            while (rset.next()) {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.city_population = rset.getInt("Population");

                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city list. Report 30");
            return null;
        }
    }


    /**
     * * report31 function
     * * returning all the capital cities in a continent organized by largest population to smallest,
     * * created for Report 31.
     * */
    public ArrayList<City> report31(String continent) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM country " +
                            "JOIN city ON Code = city.CountryCode " +
                            "WHERE continent = '" + continent + "' and city.ID = Capital " +
                            "ORDER BY city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();

            // Populate the array
            while (rset.next()) {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.city_population = rset.getInt("Population");

                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city list. Report 31");
            return null;
        }
    }

    /**
     * * report61 function
     * * returning all the countries in the world organized by largest population to smallest,
     * * created for Report 61.
     * */
    public ArrayList<Country> report61() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Population, continent " +
                            "FROM country " +
                            "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();

            // Populate the array
            while (rset.next()) {
                Country country = new Country();
                country.country_code = rset.getString("Code");
                country.country_name = rset.getString("Name");
                country.country_population = rset.getInt("Population");
                country.country_continent = rset.getString("continent");

                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country list. Report 61");
            return null;
        }
    }

}

