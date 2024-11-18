package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testGetCity()
    {
        City city = app.getCity(1);
        assertEquals(city.city_id, 255530);
        assertEquals(city.city_name, "Kabul");
        assertEquals(city.city_population, 1780000);
    }
}