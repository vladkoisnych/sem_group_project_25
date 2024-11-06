package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * UnitTest Class
 * Is used on GitHub actions and through Maven - Test
 */
public class UnitTest
{
    static App app;

    //initialisation method to launch the app class.
    @BeforeAll
    static void init()
    {
        app = new App();
    }

    //unit test to print an empty city.
    @Test
    void displayCityNull()
    {
        System.out.println("\n");
        app.displayCity(null);
    }

    //unit test to print a city that is not empty.
    @Test
    void displayCityNotNull()
    {
        City city = new City();
        city.city_id = 1;
        city.city_name = "TestCity";
        city.city_population = 1;
        System.out.println("\n");
        app.displayCity(city);
    }

    //unit test to print an empty country list.
    @Test
    void printCountryListNull()
    {
        System.out.println("\n");
        app.printCountryList(null);
    }

    //unit test to print a country list that is not empty.
    @Test
    void printCountryListNotNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country();
        country.country_code = "TST";
        country.country_name = "Test";
        country.country_population = 1111;
        countries.add(country);
        System.out.println("\n");
        app.printCountryList(countries);
    }

    //unit test for connecting to the DB. Does not work as the unit tests can't have any connections
    @Test
    void connectingToTheDB()
    {
        System.out.println("\n");

        app.connect();

        app.disconnect();
    }

}