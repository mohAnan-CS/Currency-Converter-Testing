package com.birzeit.currencyconvertertesting.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeRateServiceTest {

    public ExchangeRateService exchangeRateService;

    @BeforeEach
    void setUp() {
        exchangeRateService = new ExchangeRateService();
    }

    @AfterEach
    void tearDown() {
        exchangeRateService = null;
    }


    @Test
    void testFromCurrencyNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            exchangeRateService.getExchangeRate(null, "USD");
        });

    }

    @Test
    void testToCurrencyNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            exchangeRateService.getExchangeRate("USD", null);
        });

    }

    @Test
    void testFromCurrencyEmpty() {

        assertThrows(IllegalArgumentException.class, () -> {
            exchangeRateService.getExchangeRate("", "USD");
        });

    }

    @Test
    void testMohammad(){
        System.out.println("Mohammad");
    }

    @Test
    void testToCurrencyEmpty() {

        assertThrows(IllegalArgumentException.class, () -> {
            exchangeRateService.getExchangeRate("USD", "");
        });

    }
}