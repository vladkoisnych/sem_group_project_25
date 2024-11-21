package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
Integration tests file
Checking the individual components to make sure the app works as expected
 */
public class IntegrationTest
{
    static App app;

    /**
    Initializing the connection to the db before the integration tests
     */
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    /**
    Testing the getCity function, comparing with known records
     */
    @Test
    void testGetCity()
    {
        City city = app.getCity(1);
        assertEquals(city.city_id, 1);
        assertEquals(city.city_name, "Kabul");
        assertEquals(city.city_population, 1780000);
    }

    /**
     Testing the report14 function, comparing with known answer
     */
    @Test
    void testReport14()
    {
        ArrayList<Country> countries14 = app.report14();
        assertEquals(countries14.size(), 239);
        System.out.println("\nReport 14 works correct");
    }

    /**
     * Testing the report15 function, comparing with known answer
     */
    @Test
    void testReport15() {
        ArrayList<Country> countries15 = app.report15();
        assertEquals(46, countries15.size());
        System.out.println("\nReport 15 works correct");
    }

    /**
     * Testing the report16 function, comparing with known answer
     */
    @Test
    void testReport16() {
        ArrayList<Country> countries16 = app.report16();
        assertEquals(9, countries16.size());
        System.out.println("\nReport 16 works correct");
    }

    /**
     * Testing the report17 function, comparing with known answer
     */
    @Test
    void testReport17() {
        int n = 10;
        ArrayList<Country> countries17 = app.report17(n);
        assertEquals(10, countries17.size());
        System.out.println("\nReport 17 works correct");
    }

    /**
     * Testing the report18 function, comparing with known answer
     */
    @Test
    void testReport18() {
        String continent = "Europe";
        int n = 10;
        ArrayList<Country> countries18 = app.report18(continent, n);
        assertEquals(10, countries18.size());
        System.out.println("\nReport 18 works correct");
    }

    /**
     * Testing the report19 function, comparing with known answer
     */
    @Test
    void testReport19() {
        String region = "Western Europe";
        int n = 5;
        ArrayList<Country> countries19 = app.report19(region, n);
        assertEquals(5, countries19.size());
        System.out.println("\nReport 19 works correct");
    }

    /**
     * Testing the report21 function, comparing with known answer
     */
    @Test
    void testReport21() {
        ArrayList<City> cities21 = app.report21();
        assertEquals(841, cities21.size());
        System.out.println("\nReport 21 works correct");
    }

    /**
     * Testing the report30 function, comparing with known answer
     */
    @Test
    void testReport30() {
        ArrayList<City> cities30 = app.report30();
        assertEquals(232, cities30.size());
        System.out.println("\nReport 30 works correct");
    }

    /**
    Testing the report31 function, comparing with known answer
     */
    @Test
    void testReport31()
    {
        String continent = "Europe"; // Specify the continent
        ArrayList<City> cities31 = app.report31(continent);
        assertEquals(cities31.size(), 46);
        System.out.println("\nReport 31 works correct");
    }

    /**
     * Testing the report61 function, comparing with known answer
     */
    @Test
    void testReport61() {
        ArrayList<Country> countries61 = app.report61();
        assertEquals(239, countries61.size());
        System.out.println("\nReport 61 works correct");
    }
}