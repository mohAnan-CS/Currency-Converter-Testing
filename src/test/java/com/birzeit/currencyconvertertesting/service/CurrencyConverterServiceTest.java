package com.birzeit.currencyconvertertesting.service;

import com.birzeit.currencyconvertertesting.service.CurrencyConverterService;
import com.birzeit.currencyconvertertesting.service.ExchangeRateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class CurrencyConverterServiceTest {

    @Mock
    private CurrencyConverterService currencyConverterService;

    @Mock
    private ExchangeRateService exchangeRateService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConversionWithValidExchangeRate() throws IOException {
        // Define the behavior of the mock ExchangeRateService
        when(exchangeRateService.getExchangeRate("USD", "AED")).thenReturn(2.5);

        double expected = 375.0;

        // Define the behavior of the mock CurrencyConverterService


        double convertedAmount = currencyConverterService.convert("USD", "AED", 150.0);

        Assertions.assertEquals(expected, convertedAmount);
    }

    @Test
    void testConversionWithZeroAmount() throws IOException {
        Mockito.doThrow(IllegalArgumentException.class)
                .when(currencyConverterService)
                .convert("USD", "EUR", 0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            currencyConverterService.convert("USD", "EUR", 0);
        });
    }

    @Test
    void testConversionWithNegativeAmount() throws IOException {
        Mockito.doThrow(IllegalArgumentException.class)
                .when(currencyConverterService)
                .convert("USD", "EUR", -1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            currencyConverterService.convert("USD", "EUR", -1);
        });
    }

    @Test
    void testConversionWithEmptyFromCurrency() throws IOException {
        Mockito.doThrow(IllegalArgumentException.class)
                .when(currencyConverterService)
                .convert("", "EUR", 200);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            currencyConverterService.convert("", "EUR", 200);
        });
    }

    @Test
    void testConversionWithEmptyToCurrency() throws IOException {
        Mockito.doThrow(IllegalArgumentException.class)
                .when(currencyConverterService)
                .convert("USD", "", 200);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            currencyConverterService.convert("USD", "", 200);
        });
    }

    @Test
    void testConversionWithNullFromCurrency() throws IOException {

        Mockito.doThrow(IllegalArgumentException.class)
                .when(currencyConverterService)
                .convert(null, "EUR", 200);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            currencyConverterService.convert(null, "EUR", 200);
        });
    }

    @Test
    void testConversionWithNullToCurrency() throws IOException {
        Mockito.doThrow(IllegalArgumentException.class)
                .when(currencyConverterService)
                .convert("USD", null, 200);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            currencyConverterService.convert("USD", null, 200);
        });
    }


}
