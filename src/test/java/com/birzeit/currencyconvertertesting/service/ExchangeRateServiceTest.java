package com.birzeit.currencyconvertertesting.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExchangeRateServiceTest {

    public ExchangeRateService exchangeRateService;

    @Mock
    private HttpURLConnection connection;

    @Mock
    private BufferedReader reader;

    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/9dc6c9d4fb8fe304a72e221b";


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
    void testToCurrencyEmpty() {

        assertThrows(IllegalArgumentException.class, () -> {
            exchangeRateService.getExchangeRate("USD", "");
        });

    }
}