package com.birzeit.currencyconvertertesting.service;

import com.birzeit.currencyconvertertesting.model.Currency;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

class CurrencyInitializationServiceTest {

    public CurrencyInitializationService currencyInitializationService;
    public CurrencyService currencyService;

    @BeforeEach
    void setUp() {

        currencyService = new CurrencyService();
        currencyInitializationService = new CurrencyInitializationService(currencyService);

    }

    @AfterEach
    void tearDown() {

        currencyInitializationService = null;
        currencyService = null;

    }

    @Test
    void checkPathFileIsEmpty() throws IOException {

        //Assert that the file is empty could make exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            currencyInitializationService.readCurrencyDataFromFile("");
        });

    }

    @Test
    void checkPathFileIsNull() throws IOException {

        //Assert that the file is null could make exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            currencyInitializationService.readCurrencyDataFromFile(null);
        });

    }

    @Test
    void checkFileIsNotEmpty() throws IOException {

        List<Currency> currencyList = currencyInitializationService.readCurrencyDataFromFile("C:\\Users\\twitter\\IdeaProjects\\CurrencyConverterTesting\\currency.txt");
        Assertions.assertTrue(currencyList.size() > 0);

    }

    @Test
    void checkFileIsEmpty() throws IOException {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            currencyInitializationService.readCurrencyDataFromFile("C:\\Users\\twitter\\IdeaProjects\\CurrencyConverterTesting\\empty.txt");
        });

    }
}