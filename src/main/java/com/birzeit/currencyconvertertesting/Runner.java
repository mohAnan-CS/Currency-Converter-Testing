package com.birzeit.currencyconvertertesting;

import com.birzeit.currencyconvertertesting.service.CurrencyConverterService;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {

        CurrencyConverterService currencyConverterService = new CurrencyConverterService();
        Double result = currencyConverterService.convert("USD", "ILS", 0);
        System.out.println(result);

    }
}
