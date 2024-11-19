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
    Testing the report31 function, comparing with known answer
     */
    @Test
    void testReport31()
    {
        String continent = "Europe"; // Specify the continent
        ArrayList<City> cities31 = app.report31(continent);
        assertEquals(cities31.size(), 46);
    }
}