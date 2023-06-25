package com.birzeit.currencyconvertertesting;

import com.birzeit.currencyconvertertesting.service.CurrencyConverterService;
import com.birzeit.currencyconvertertesting.service.ExchangeRateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
class CurrencyConverterTesting {

    CurrencyConverterService currencyConverterService = new CurrencyConverterService();
    ExchangeRateService exchangeRateService = new ExchangeRateService();

    @Test
    public void testConversionWithValidExchangeRate() throws IOException {

        double exchangeRate = exchangeRateService.getExchangeRate("USD", "AED");
        double expected = exchangeRate* 150;

        double convertedAmount = currencyConverterService.convert("USD", "AED", 150.0);

        Assertions.assertEquals(expected, convertedAmount);
    }

    @Test
    public void testConversionWithZeroAmount() throws IOException {

        assertThrows(IllegalArgumentException.class, () -> {
            currencyConverterService.convert("USD", "EUR", 0);
        });

    }

    @Test
    public void testConversionWithNegativeAmount() throws IOException {

        assertThrows(IllegalArgumentException.class, () -> {
            currencyConverterService.convert("USD", "EUR", -1);
        });

    }

    @Test
    public void testConversionWithEmptyFromCurrency() throws IOException {

        assertThrows(IllegalArgumentException.class, () -> {
            currencyConverterService.convert("", "EUR", 200);
        });

    }

    @Test
    public void testConversionWithEmptyToCurrency() throws IOException {

        assertThrows(IllegalArgumentException.class, () -> {
            currencyConverterService.convert("USD", "", 200);
        });

    }

    @Test
    public void testConversionWithNullFromCurrency() throws IOException {

        assertThrows(IllegalArgumentException.class, () -> {
            currencyConverterService.convert(null, "EUR", 200);
        });

    }

    @Test
    public void testConversionWithNullToCurrency() throws IOException {

        assertThrows(IllegalArgumentException.class, () -> {
            currencyConverterService.convert("USD", null, 200);
        });

    }


}
