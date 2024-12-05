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

    /**
     * Testing the report22 function, comparing with known answer
     */
    @Test
    void testReport22() {
        String region = "Western Europe";
        ArrayList<City> cities22 = app.report22(region);
        assertEquals(186, cities22.size());
    }

    /**
     * Testing the report23 function, comparing with known answer
     */
    @Test
    void testReport23() {
        String country = "Germany";
        ArrayList<City> cities23 = app.report23(country);
        assertEquals(93, cities23.size());
    }

    /**
     * Testing the report24 function, comparing with known answer
     */
    @Test
    void testReport24() {
        String district = "Buenos Aires";
        ArrayList<City> cities24 = app.report24(district);
        assertEquals(31, cities24.size());
    }

    /**
     * Testing the report28 function, comparing with known answer
     */
    @Test
    void testReport28() {
        String country = "Germany";
        int n = 10;
        ArrayList<City> cities28 = app.report28(country, n);
        assertEquals(10, cities28.size());
    }

    /**
     * Testing the report34 function, comparing with known answer
     */
    @Test
    void testReport34() {
        String continent = "Asia";
        int n = 5;
        ArrayList<City> topCapitalCities = app.report34(continent, n);
        assertEquals(5, topCapitalCities.size());
    }
    /**
     * Testing the report29 function, comparing with known answer
     */
    @Test
    void testReport29() {
        String district = "Buenos Aires"; // Specify the district
        int n = 10; // Specify top N cities
        ArrayList<City> cities29 = app.report29(district, n);
        assertEquals(10, cities29.size());
        System.out.println("Report 29 size: " + cities29.size());
    }

    /**
     * Testing the report32 function, comparing with known answer
     */
    @Test
    void testReport32() {
        String region = "Western Europe"; // Specify the region
        ArrayList<City> cities32 = app.report32(region);
        assertEquals(9, cities32.size());
        System.out.println("Report 32 size: " + cities32.size());
    }

    /**
     * Testing the report35 function, comparing with known answer
     */
    @Test
    void testReport35() {
        String region = "Western Europe"; // Specify the region
        int n = 5; // Specify top N cities
        ArrayList<City> cities35 = app.report35(region, n);
        assertEquals(5, cities35.size());
        System.out.println("Report 35 size: " + cities35.size());
    }

    /**
     * Testing the report38 function, comparing with known answer
     */
    @Test
    void testReport38() {
        app.report38();
    }

    /**
     * Testing the report49 function, comparing with known answer
     */
    @Test
    void testReport49() {
        long report49 = app.report49();
        assertEquals(6078749450L, report49);
        System.out.println("\n Report49. Population of the world " + report49);
    }

    /**
     * Testing the report50 function, comparing with known answer
     */
    @Test
    void testReport50() {
        String continent = "Europe"; // Specify the continent
        long report50 = app.report50(continent);
        assertEquals(730074600L, report50);
        System.out.println("\n Report50. Population of the continent " + report50);
    }

    /**
     * Testing the report51 function, comparing with known answer
     */
    @Test
    void testReport51() {
        String region = "Western Europe"; // Specify the region
        long report51 = app.report51(region);
        assertEquals(183247600L, report51);
        System.out.println("\n Report51. Population of the region " + report51);
    }

    /**
     * Testing the report53 function, comparing with known answer
     */
    @Test
    void testReport53() {
        String district = "Buenos Aires"; // Specify the district
        long report53 = app.report53(district);
        assertEquals(10530136L, report53);
        System.out.println("\n Report53. Population of the district " + report53);
    }

    /**
     * Testing the report54 function, comparing with known answer
     */
    @Test
    void testReport54() {
        String city = "Edinburgh"; // Specify the city
        long report54 = app.report54(city);
        assertEquals(450180L, report54);
        System.out.println("\n Report54. Population of the city " + report54);
    }

    /**
     * Testing the report20 function, comparing with known answer
     */
    @Test
    void testReport20() {
        ArrayList<City> cities20 = app.report20();
        assertEquals(4079, cities20.size());
        System.out.println("Report 20 size: " + cities20.size());
    }

    /**
     * Testing the report26 function, comparing with known answer
     */
    @Test
    void testReport26() {
        String continent = "Asia"; // Specify the continent
        int n = 5; // Specify top N populated cities
        ArrayList<City> cities26 = app.report26(continent, n);
        assertEquals(5, cities26.size());
        System.out.println("Report 26 size: " + cities26.size());
    }

    /**
     * Testing the report27 function, comparing with known answer
     */
    @Test
    void testReport27() {
        String region = "Western Europe"; // Specify the region
        int n = 10; // Specify top N cities
        ArrayList<City> cities27 = app.report27(region, n);
        assertEquals(10, cities27.size());
        System.out.println("Report 27 size: " + cities27.size());
    }

    /**
     * Testing the report25 function, comparing with known answer
     */
    @Test
    void testReport25() {
        int n = 5; // Specify top N populated cities
        ArrayList<City> cities25 = app.report25(n);
        assertEquals(5, cities25.size());
        System.out.println("Report 25 size: " + cities25.size());
    }

    /**
     * Testing the report33 function, comparing with known answer
     */
    @Test
    void testReport33() {
        int n = 5; // Specify top N populated capital cities
        ArrayList<City> cities33 = app.report33(n);
        assertEquals(5, cities33.size());
        System.out.println("Report 33 size: " + cities33.size());
    }

    /**
     * Testing the report52 function, comparing with known answer
     */
    @Test
    void testReport52() {
        String country = "Germany"; // Specify the country
        long report52 = app.report52(country);
        assertEquals(82164700L, report52);
        System.out.println("\n Report52. Population of the country " + report52);
    }


}