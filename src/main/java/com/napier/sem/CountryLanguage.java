package com.napier.sem;

/**
 * Represents a country`s language.
 * There may be a few languages per country,
 * and they may repeat in different countries.
 */
public class CountryLanguage
{
    /**
     * country code
     */
    public String language_countryCode;

    /**
     *  Language Name
     */
    public String language_name;

    /**
     * Is language official? T/F
     */
    public boolean language_isOfficial;

    /**
     * Language Percentage of Usage in the Country
     */
    public float language_percentage;
}