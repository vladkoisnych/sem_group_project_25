package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ReportsTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void displayCityNull()
    {
        app.displayCity(null);
    }

    @Test
    void displayCityNotNull()
    {
        City city = new City();
        city.city_id = 1;
        city.city_name = "TestCity";
        city.city_population = 1;
        app.displayCity(city);
    }

    @Test
    void printCountryListNull()
    {
        app.printCountryList(null);
    }

    @Test
    void printCountryListNotNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country();
        country.country_code = "TST";
        country.country_name = "Test";
        country.country_population = 1111;
        countries.add(country);
        app.printCountryList(countries);
    }


}