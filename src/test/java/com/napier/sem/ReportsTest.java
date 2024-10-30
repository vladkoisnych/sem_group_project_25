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

        app.connect();
    }

    @Test
    void report14TestSize()
    {
        ArrayList<Country> test14 = app.report14();
        System.out.println(test14.size());
        System.out.println(test14.size() == 239);
    }

    @Test
    void report15TestSize()
    {
        ArrayList<Country> test15 = app.report15();
        System.out.println(test15.size());
        System.out.println(test15.size() == 46);
    }

    @AfterAll
    static void end(){
        app.disconnect();
    }
}