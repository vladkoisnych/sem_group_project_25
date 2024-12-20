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
        System.out.println("Release 0.1.0.4");

//report 14
        ArrayList<Country> countries14 = a.report14();
        System.out.println("\nReport 14. All the countries in the world organised by largest population to smallest: ");
        printCountryList(countries14);

//report 15
        ArrayList<Country> countries15 = a.report15();
        System.out.println("\nReport 15. All the countries in a continent organised by largest population to smallest : ");
        printCountryList(countries15);

//report 16
        ArrayList<Country> countries16 = a.report16();
        System.out.println("\nReport 16. All the countries in a region organised by largest population to smallest : ");
        printCountryList(countries16);


//report 17
        int n = 10; // Specify the top N countries
        ArrayList<Country> countries17 = a.report17(n);
        System.out.println("\nReport 17. The top N populated countries in the world where N is provided by the user : " );
        printCountryList(countries17);


// report 18
        String continent = "Europe"; // Specify the continent
        n = 10; // Specify the top N countries
        ArrayList<Country> countries18 = a.report18(continent, n);
        System.out.println("\nReport 18. The top N populated countries in a continent where N is provided by the user : ");
        printCountryList(countries18);


// report 19
        String region = "Western Europe"; // Specify the region
        n = 5; // Specify the top N countries
        ArrayList<Country> countries19 = a.report19(region, n);
        System.out.println("\nReport 19. The top N populated countries in a region where N is provided by the user : ");
        printCountryList(countries19);

        // report 20
        ArrayList<City> cities20 = a.report20();
        System.out.println("\nReport 20. All the cities in the world organised by largest population to smallest : ");
        printCityList(cities20);


// report 21
        ArrayList<City> cities21 = a.report21();
        System.out.println("\nReport 21. All the cities in a continent organised by largest population to smallest : ");
        printCityList(cities21);


// report 22
        region = "Western Europe"; // Specify the region
        ArrayList<City> cities22 = a.report22(region);
        System.out.println("\nReport 22. All the cities in a region organised by largest population to smallest : ");
        printCityList(cities22);

        // report 23
        String country = "Germany"; // Specify the country
        ArrayList<City> cities23 = a.report23(country);
        System.out.println("\nReport 23. All the cities in a country organised by largest population to smallest : ");
        printCityList(cities23);

// report 24
        String district = "Buenos Aires"; // Specify the district
        ArrayList<City> cities24 = a.report24(district);
        System.out.println("\nReport 24. All the cities in a district organised by largest population to smallest : ");
        printCityList(cities24);

        // report 25
        n = 5; // Specify the top N populated cities
        ArrayList<City> cities25 = a.report25(n);
        System.out.println("\nReport 25. The top N populated cities in the world where N is provided by the user : ");
        printCityList(cities25);

        // report 26
        continent = "Asia"; // Specify the continent
        n = 5; // Specify the top N populated cities
        ArrayList<City> cities26 = a.report26(continent, n);
        System.out.println("\nReport 26. The top N populated cities in a continent where N is provided by the user : ");
        printCityList(cities26);

// report 27
        region = "Western Europe"; // Specify the region
        n = 10; //specify top N cities
        ArrayList<City> cities27 = a.report27(region, n);
        System.out.println("\nReport 27. The top N populated cities in a region where N is provided by the user : ");
        printCityList(cities27);

        // report 28
        country = "Germany"; // Specify the district
        n = 10; //specify top N cities
        ArrayList<City> cities28 = a.report28(country, n);
        System.out.println("\nReport 28. The top N populated cities in a country where N is provided by the user : ");
        printCityList(cities28);

        // report 29
        district = "Buenos Aires"; // Specify the district
        n = 10; //specify top N cities
        ArrayList<City> cities29 = a.report29(district, n);
        System.out.println("\nReport 29. The top N populated cities in a district where N is provided by the user : ");
        printCityList(cities29);

// report 30
        ArrayList<City> cities30 = a.report30();
        System.out.println("\nReport 30. All the capital cities in the world organised by largest population to smallest : ");
        printCityList(cities30);

// report 31
        continent = "Europe"; // Specify the continent
        ArrayList<City> cities31 = a.report31(continent);
        System.out.println("\nReport 31. All the capital cities in a continent organised by largest population to smallest : ");
        printCityList(cities31);

        // report 32
        region = "Western Europe"; // Specify the region
        ArrayList<City> cities32 = a.report32(region);
        System.out.println("\nReport 32. All the capital cities in a region organised by largest to smallest : ");
        printCityList(cities32);

        // report 33
        n = 5; // Specify the top N populated capital cities
        ArrayList<City> cities33 = a.report33(n);
        System.out.println("\nReport 33. The top N populated capital cities in the world where N is provided by the user : ");
        printCityList(cities33);


        // report 34
        continent = "Asia"; // Specify the continent
        n = 5; // Specify the top N populated capital cities
        ArrayList<City> topCapitalCities = a.report34(continent, n);
        System.out.println("\nReport 34. The top N populated capital cities in a continent where N is provided by the user : ");
        printCityList(topCapitalCities);

        // report 35
        region = "Western Europe"; // Specify the region
        n = 5; //specify top N cities
        ArrayList<City> cities35 = a.report35(region, n);
        System.out.println("\nReport 35. The top N populated capital cities in a region where N is provided by the user : ");
        printCityList(cities35);


        //report 36
        System.out.println("\nReport 36. The population of people, people living in cities, and people not living in cities in each continent : ");
        a.report36();

        //report 37
        System.out.println("\nReport 37. The population of people, people living in cities, and people not living in cities in each region : ");
        a.report37();


        // report 38
        System.out.println("\nReport 38. The population of people, people living in cities, and people not living in cities in each country : ");
        a.report38();



// report 49
        long report49 = a.report49();
        System.out.println("\n Report49. Population of the world " + report49);

// report 50
        continent = "Europe"; // Specify the continent
        long report50 = a.report50(continent);
        System.out.println("\n Report50. Population of the " + continent + " continent " + report50);

// report 51
        region = "Western Europe"; // Specify the region
        long report51 = a.report51(region);
        System.out.println("\n Report51. Population of the " + region + " region : " + report51);

        //report 52
        country = "Germany";
        a.report52(country);
        System.out.println("\n Report52. Population of the " + country + " country : " + a.report52(country));

// report 53
        district = "Buenos Aires"; // Specify the district
        long report53 = a.report53(district);
        System.out.println("\n Report53. Population of the " + district + " district : " + report53);

// report 54
        String city = "Edinburgh"; // Specify the district
        long report54 = a.report54(city);
        System.out.println("\n Report54. Population of the " + city + " city : " + report54);

//report 56
        System.out.println("\n Report 56. Country Report : ");
        country = "Germany";
        Country country56 = a.report56(country);
        printCountryDetails(country56);

//report 57
        System.out.println("\n Report 57. City Report : ");
        city = "Edinburgh";
        City city57 = a.report57(city);
        printCityDetails(city57);

//report 58
        System.out.println("\n Report 58. Capital City Report : ");
        city = "London";
        City city58 = a.report58(city);
        printCityDetails(city58);


        //report 59
        System.out.println("\n Report 59. Continent Population Report : ");
        a.report59();


// report 61
        ArrayList<Country> countries61 = a.report61();
        System.out.println("\nReport 61. Country Population Report : " );
        printCountryList(countries61);


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
                            + "WHERE ID = '" + ID + "' ";
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
     * * printCityList function
     * * printing the details of a city list
     * * @param cities - array list filled with cities
     * */
    public static void printCityList(ArrayList<City> cities)
    {
        if (cities == null){
            System.out.println("No cities");
            return;
        }


        if (!cities.isEmpty()) {
            for (City city : cities) {

                if (city == null) continue;

                String cityStr = new String();

                cityStr += "ID: " + city.city_id + "\n";
                cityStr += "Name: " + city.city_name + "\n";
                cityStr += "Population: " + city.city_population;

                System.out.println(cityStr);
            }
        }else System.out.println("City list is empty");
    }

    /**
     * * printCountryDetails function
     * * printing the details of a country,
     * * created for testing purposes while implementing unit testing
     * * @param country
     * */
    public static void printCountryDetails(Country country)
    {
        if (country != null) {
            String countryStr = new String();

            countryStr += "Code: " + country.country_code + "\n";
            countryStr += "Name: " + country.country_name + "\n";
            countryStr += "Continent: " + country.country_continent + "\n";
            countryStr += "Region: " + country.country_region + "\n";
            countryStr += "Population: " + country.country_population + "\n";
            countryStr += "CapitalId : " + country.country_capital;

            System.out.println(countryStr);
        }else {
            System.out.println("No country");
            return;
        }

    }

    /**
     * * printCityDetails function
     * * printing the details of a city,
     * * created for testing purposes while implementing unit testing
     * * @param city
     * */
    public static void printCityDetails(City city)
    {
        if (city != null) {
            String cityStr = new String();

            cityStr += "ID: " + city.city_id + "\n";
            cityStr += "Name: " + city.city_name + "\n";
            cityStr += "Country: " + city.city_countryCode + "\n";
            cityStr += "District: " + city.city_district + "\n";
            cityStr += "Population: " + city.city_population;


            System.out.println(cityStr);
        }else {
            System.out.println("No city");
            return;
        }

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
    /**
     * * report22 function
     * * returning all the cities in a region organized by largest population to smallest,
     * * created for Report 22.
     * */
    public ArrayList<City> report22(String region) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM country " +
                            "JOIN city ON Code = city.CountryCode " +
                            "WHERE region = '" + region + "' " +
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
            System.out.println("Failed to get city list. Report 22");
            return null;
        }
    }
    /**
     * * report23 function
     * * returning all the cities in a country organized by largest population to smallest,
     * * created for Report 23.
     * */
    public ArrayList<City> report23(String country) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM country " +
                            "JOIN city ON Code = city.CountryCode " +
                            "WHERE country.Name = '" + country + "' " +
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
            System.out.println("Failed to get city list. Report 23");
            return null;
        }
    }

    /**
     * * report24 function
     * * returning all the cities in a district organized by largest population to smallest,
     * * created for Report 24.
     * */
    public ArrayList<City> report24(String district) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM country " +
                            "JOIN city ON Code = city.CountryCode " +
                            "WHERE District = '" + district + "' " +
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
            System.out.println("Failed to get city list. Report 24");
            return null;
        }
    }

    /**
     * * report28 function
     * * returning the top N populated cities in a country, where N is provided by the user
     * * created for report 28.
     * * @param n - n populated city in the world, is provided by the user
     * */
    public ArrayList<City> report28(String country, int n) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM country " +
                            "JOIN city ON Code = city.CountryCode " +
                            "WHERE country.Name = '" + country + "' " +
                            "ORDER BY city.Population DESC "+
                            "LIMIT " + n;
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
            System.out.println("Failed to get city list. Report 28");
            return null;
        }
    }


    /**
     * * report34 function
     * * returning the top N populated capital cities in a continent, where N and continent is provided by the user
     * * created for report 34.
     * * @param n - n populated city in the world, is provided by the user
     * * @param continent - target continent, provided by the user
     * */
    public ArrayList<City> report34(String continent, int n) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement to get the top N populated capital cities in a continent
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.ID = country.Capital " +
                            "WHERE country.Continent = '" + continent + "' " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + n;

// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> capitalCities = new ArrayList<>();

// Populate the array with capital city data
            while (rset.next()) {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.city_population = rset.getInt("Population");

                capitalCities.add(city);
            }
            return capitalCities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities list. Report 34");
            return null;
        }
    }

    /**
     * * report29 function
     * * returning the top N populated cities in a district, where N is provided by the user
     * * created for report 29.
     * * @param n - n populated city in a district, is provided by the user
     * */
    public ArrayList<City> report29(String district, int n) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM country " +
                            "JOIN city ON Code = city.CountryCode " +
                            "WHERE District = '" + district + "' " +
                            "ORDER BY city.Population DESC "+
                            "LIMIT " + n;
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
            System.out.println("Failed to get city list. Report 29");
            return null;
        }
    }

    /**
     * * report32 function
     * * returning all capital cities in a region organised from the largest population to smallest
     * * created for report 32.
     * */
    public ArrayList<City> report32(String region) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM country " +
                            "JOIN city ON Code = city.CountryCode " +
                            "WHERE region = '" + region + "' and city.ID = Capital " +
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
            System.out.println("Failed to get city list. Report 32");
            return null;
        }
    }

    /**
     * * report35 function
     * * returning the top N capital cities in a region organised from the largest population to smallest
     * * created for report 35.
     * */
    public ArrayList<City> report35(String region, int N ) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM country " +
                            "JOIN city ON Code = city.CountryCode " +
                            "WHERE region = '" + region + "' and city.ID = Capital " +
                            "ORDER BY city.Population DESC " +
                            "Limit " + N;
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
            System.out.println("Failed to get city list. Report 35");
            return null;
        }
    }

    /**
     * * report38 function
     * * returning population of each country that live in cities and not in cities
     * * created for report 38.
     * */
    public void report38() {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT country.Name as Country, SUM(city.Population) AS cities, (country.Population-SUM(city.Population)) AS other " +
                            "FROM country " +
                            "JOIN city ON Code = city.CountryCode " +
                            "GROUP By Code";
// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //print the template
            System.out.print("\n" + "Country" + " ");
            System.out.print("Cities" + "/");
            System.out.print("Not in Cities" + "\n");

//print the answers
            while (rset.next()) {
                System.out.print(rset.getString("Country") + " ");
                System.out.print(rset.getString("cities") + "/");
                System.out.print(rset.getString("other") + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city list. Report 38");
        }
    }

    /**
     * * report49 function
     * * returning the population of the world
     * * created for report 49.
     * */
    public long report49() {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) as pop " +
                            "FROM country ";
// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            long totalPopulation = 0;

// Populate the array
            if (rset.next()) {
                Country country = new Country();
                totalPopulation = rset.getLong("pop");


            }
            return totalPopulation;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country list. Report 49");
            return 0;
        }
    }

    /**
     * * report50 function
     * * returning the population a continent
     * * created for report 50.
     * */
    public long report50(String continent) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) as pop " +
                            "FROM country " +
                            "WHERE continent = '" + continent + "' ";
// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            long totalPopulation = 0;

// Populate the array
            while (rset.next()) {
                totalPopulation = rset.getInt("pop");

            }
            return totalPopulation;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country list. Report 50");
            return 0;
        }
    }

    /**
     * * report51 function
     * * returning the population of a region
     * * created for report 51.
     * */
    public long report51(String region) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) as pop " +
                            "FROM country " +
                            "WHERE region = '" + region + "' ";
// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            long totalPopulation = 0;

// Populate the array
            while (rset.next()) {
                totalPopulation = rset.getInt("pop");

            }
            return totalPopulation;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country list. Report 51");
            return 0;
        }
    }

    /**
     * * report53 function
     * * returning the population of a district
     * * created for report 53.
     * */
    public long report53(String district) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) as pop " +
                            "FROM city " +
                            "WHERE district = '" + district + "' ";
// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            long totalPopulation = 0;

// Populate the array
            while (rset.next()) {
                totalPopulation = rset.getInt("pop");
            }
            return totalPopulation;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country list. Report 53");
            return 0;
        }
    }

    /**
     * * report54 function
     * * returning the population of a city
     * * created for report 54.
     * */
    public long report54(String name) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) as pop " +
                            "FROM city " +
                            "WHERE name = '" + name + "' ";
// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            long totalPopulation = 0;

// Populate the array
            while (rset.next()) {

                totalPopulation = rset.getLong("pop");
            }
            return totalPopulation;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country list. Report 54");
            return 0;
        }
    }

    /**
     * * report56 function
     * * returning the information of a country
     * * created for report 56.
     * */
    public Country report56(String name) {
        try
        {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE name = '" + name + "' ";
// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
// Return new country if valid.
// Check one is returned
            if (rset.next())
            {
                Country country = new Country();
                country.country_code = rset.getString("Code");
                country.country_name = rset.getString("Name");
                country.country_continent = rset.getString("Continent");
                country.country_region = rset.getString("Region");
                country.country_population = rset.getInt("Population");
                country.country_capital = rset.getInt("Capital");

                return country;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * * report57 function
     * * returning the information of a city
     * * created for report 57.
     * */
    public City report57(String name)
    {
        try
        {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode , District, Population "
                            + "FROM city "
                            + "WHERE Name = '" + name + "' ";
// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
// Return new city if valid.
// Check one is returned
            if (rset.next())
            {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.city_countryCode = rset.getString("CountryCode");
                city.city_district = rset.getString("District");
                city.city_population = rset.getInt("Population");
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
     * * report58 function
     * * returning the information of a capital city
     * * created for report 58.
     * */
    public City report58(String name)
    {
        try
        {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.ID = country.Capital " +
                            "WHERE city.Name = '" + name + "' ";
// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
// Return new city if valid.
// Check one is returned
            if (rset.next())
            {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.city_countryCode = rset.getString("CountryCode");
                city.city_district = rset.getString("District");
                city.city_population = rset.getInt("Population");
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
     * * report20 function
     * * returning all the cities in the world organized by largest population to smallest,
     * * created for Report 20.
     * */
    public ArrayList<City> report20() {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, Population " +
                            "FROM city " +
                            "ORDER BY Population DESC ";
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
            System.out.println("Failed to get city list. Report 20");
            return null;
        }
    }

    /**
     * * report26 function
     * * returning the top N populated cities in a continent, where N and continent is provided by the user
     * * created for report 26.
     * * @param n - n populated cities the world, is provided by the user
     * * @param continent - target continent, provided by the user
     * */
    public ArrayList<City> report26(String continent, int n) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement to get the top N populated capital cities in a continent
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM country " +
                            "JOIN city ON Code = city.CountryCode " +
                            "WHERE country.Continent = '" + continent + "' " +
                            "ORDER BY city.Population DESC "+
                            "LIMIT " + n;

// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();

// Populate the array with city data
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
            System.out.println("Failed to get cities list. Report 26");
            return null;
        }
    }
    /**
     * * report27 function
     * * returning the top N populated cities in a region, where N is provided by the user
     * * created for report 27.
     * * @param n - n populated city in a region, is provided by the user
     * */
    public ArrayList<City> report27(String region, int n) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM country " +
                            "JOIN city ON Code = city.CountryCode " +
                            "WHERE Region = '" + region + "' " +
                            "ORDER BY city.Population DESC "+
                            "LIMIT " + n;
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
            System.out.println("Failed to get city list. Report 27");
            return null;
        }
    }
    /**
     * * report25 function
     * * returning the top N populated cities in the world, where N is provided by the user
     * * created for report 25.
     * * @param n - n populated city in the world, is provided by the user
     * */
    public ArrayList<City> report25(int n) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement to get the top N populated cities in the world
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM country " +
                            "JOIN city ON CODE = city.CountryCode " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + n;

// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();

// Populate the array with capital city data
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
            System.out.println("Failed to get cities list. Report 25");
            return null;
        }
    }
    /**
     * * report33 function
     * * returning the top N populated capital cities in the world, where N is provided by the user
     * * created for report 33.
     * * @param n - n populated city in the world, is provided by the user
     * */
    public ArrayList<City> report33(int n) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement to get the top N populated cities in the world
            String strSelect =
                    "SELECT city.ID, city.Name, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.ID = country.Capital " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + n;
// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> capitalCities = new ArrayList<>();

// Populate the array with capital city data
            while (rset.next()) {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.city_population = rset.getInt("Population");

                capitalCities.add(city);
            }
            return capitalCities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities list. Report 33");
            return null;
        }
    }
    /**
     * * report36 function
     * * returning population of each continent that live in cities and not in cities
     * * created for report 36.
     * */
    public void report36() {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();
// Create string for SQL statement
            String strSelect =
                    "SELECT " +
                            " Continent, " +
                            " SUM(cities_population) AS cities, " +
                            " SUM(total_population - cities_population) AS other, " +
                            " SUM(total_population) AS total " +
                            "FROM (" +
                            " SELECT " +
                            " country.Continent, " +
                            " country.Population AS total_population, " +
                            " COALESCE(SUM(city.Population), 0) AS cities_population " +
                            " FROM " +
                            " country " +
                            " LEFT JOIN " +
                            " city ON country.Code = city.CountryCode " +
                            " GROUP BY " +
                            " country.Code" +
                            ") AS subquery " +
                            "GROUP BY " +
                            " Continent";
// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);



//print the template
            System.out.print("\n" + "Continent" + " ");
            System.out.print("Cities" + "/");
            System.out.print("Not in Cities" + "\n");

//print the answers
            while (rset.next()) {
                System.out.print(rset.getString("Continent") + " ");
                System.out.print(rset.getString("cities") + "/");
                System.out.print(rset.getString("other") + "\n");

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list. Report 36");

        }
    }

    /**
     * * report37 function
     * * returning the population of people, people living in cities, and people not living in cities in each region
     * * created for report 37.
     */
    public void report37() {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();

// SQL query to calculate population in cities and outside cities for each region
            String strSelect =
                    "SELECT " +
                            " Region, " +
                            " SUM(cities_population) AS cities, " +
                            " SUM(total_population - cities_population) AS other, " +
                            " SUM(total_population) AS total_population " +
                            "FROM (" +
                            " SELECT " +
                            " country.Region, " +
                            " country.Population AS total_population, " +
                            " COALESCE(SUM(city.Population), 0) AS cities_population " +
                            " FROM " +
                            " country " +
                            " LEFT JOIN " +
                            " city ON country.Code = city.CountryCode " +
                            " GROUP BY " +
                            " country.Code" +
                            ") AS subquery " +
                            "GROUP BY " +
                            " Region";

// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

//print the template
            System.out.print("\n" + "Region" + " ");
            System.out.print("Cities" + "/");
            System.out.print("Not in Cities" + "\n");

//print the answers
            while (rset.next()) {
                System.out.print(rset.getString("Region") + " ");
                System.out.print(rset.getString("cities") + "/");
                System.out.print(rset.getString("other") + "\n");


            }

//return regions;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get region population details. Report 37");
//return null;
        }
    }

    /**
     * * report52 function
     * * returning the population of a given country
     * * created for report 52.
     */
    public int report52(String countryName) {
        try {
// Create an SQL statement
            Statement stmt = con.createStatement();

// SQL query to get the population of a country by its name
            String strSelect =
                    "SELECT Code, Name, Population " +
                            "FROM country " +
                            "WHERE Name = '" + countryName + "' ";

// Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);



// Return new country if valid
            if (rset.next()) {
                Country country = new Country();
                country.country_code = rset.getString("Code");
                country.country_name = rset.getString("Name");
                country.country_population = rset.getInt("Population");

                return country.country_population;
            } else {
                return 0; // Country not found
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country population details for Report 52");
            return 0;
        }
    }

    /**
     * * report59 function
     * * returning the population details of each continent
     * * created for report 59.
     */
    public void report59() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // SQL query to calculate the population of each continent and the population in and out of cities
            String strSelect =
                    "SELECT " +
                            "    Continent, " +
                            "    SUM(total_population) AS total_population, " +
                            "    SUM(cities_population) AS population_in_cities, " +
                            "    SUM(total_population - cities_population) AS population_not_in_cities, " +
                            "    ROUND((SUM(cities_population) / SUM(total_population)) * 100, 2) AS percentage_in_cities, " +
                            "    ROUND((SUM(total_population - cities_population) / SUM(total_population)) * 100, 2) AS percentage_not_in_cities " +
                            "FROM (" +
                            "    SELECT " +
                            "        country.Continent, " +
                            "        country.Population AS total_population, " +
                            "        COALESCE(SUM(city.Population), 0) AS cities_population " +
                            "    FROM " +
                            "        country " +
                            "    LEFT JOIN " +
                            "        city ON country.Code = city.CountryCode " +
                            "    GROUP BY " +
                            "        country.Code" +
                            ") AS subquery " +
                            "GROUP BY " +
                            "    Continent";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);


//print the template
            System.out.print("\n" + "Continent" + " ");
            System.out.print("Cities" + "/");
            System.out.print("Not in Cities" + " ");
            System.out.print("% in Cities" + " ");
            System.out.print("% Not in Cities" + "\n");

//print the answers
            while (rset.next()) {
                System.out.print(rset.getString("Continent") + " ");
                System.out.print(rset.getString("population_in_cities") + "/");
                System.out.print(rset.getString("population_not_in_cities") + " ");
                System.out.print(rset.getString("percentage_in_cities") + "/");
                System.out.print(rset.getString("percentage_not_in_cities") + "\n");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent population details for Report 59");
        }
    }


}