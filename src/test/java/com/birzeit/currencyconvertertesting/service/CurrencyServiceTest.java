package com.birzeit.currencyconvertertesting.service;

import com.birzeit.currencyconvertertesting.model.Currency;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyServiceTest {

    CurrencyService currencyService;

    @BeforeEach
    void setUp() {
        currencyService = new CurrencyService();
    }

    @AfterEach
    void tearDown() {
        currencyService = null;
    }

    @Test
    void testCurrencyNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            currencyService.save(null);
        });

    }

    @Test
    void testCurrencyNameNull() {

        Currency currency = new Currency();
        currency.setCurrencyName(null);
        currency.setCurrencyCode("USD");
        currency.setCountry("USA");

        assertThrows(IllegalArgumentException.class, () -> {
            currencyService.save(currency);
        });

    }

    @Test
    void testCurrencyNameEmpty() {

        Currency currency = new Currency();
        currency.setCurrencyName("");
        currency.setCurrencyCode("USD");
        currency.setCountry("USA");

        assertThrows(IllegalArgumentException.class, () -> {
            currencyService.save(currency);
        });

    }

    @Test
    void testCurrencyCodeNull() {

        Currency currency = new Currency();
        currency.setCurrencyName("Dollar");
        currency.setCurrencyCode(null);
        currency.setCountry("USA");

        assertThrows(IllegalArgumentException.class, () -> {
            currencyService.save(currency);
        });

    }

    @Test
    void testCurrencyCodeEmpty() {

        Currency currency = new Currency();
        currency.setCurrencyName("Dollar");
        currency.setCurrencyCode("");
        currency.setCountry("USA");

        assertThrows(IllegalArgumentException.class, () -> {
            currencyService.save(currency);
        });

    }

    @Test
    void testCountryNull() {

        Currency currency = new Currency();
        currency.setCurrencyName("Dollar");
        currency.setCurrencyCode("USD");
        currency.setCountry(null);

        assertThrows(IllegalArgumentException.class, () -> {
            currencyService.save(currency);
        });

    }

    @Test
    void testCountryEmpty() {

        Currency currency = new Currency();
        currency.setCurrencyName("Dollar");
        currency.setCurrencyCode("USD");
        currency.setCountry("");

        assertThrows(IllegalArgumentException.class, () -> {
            currencyService.save(currency);
        });

    }

    @Test
    void testCurrencyNameInValidLength() {

        Currency currency = new Currency();
        currency.setCurrencyName("United States Dollar");
        currency.setCurrencyCode("UD");
        currency.setCountry("USA");

        assertThrows(IllegalArgumentException.class, () -> {
            currencyService.save(currency);
        });

    }


}