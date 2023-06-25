package com.birzeit.currencyconvertertesting;

import com.birzeit.currencyconvertertesting.service.CurrencyConverterService;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {

        CurrencyConverterService currencyConverterService = new CurrencyConverterService();
        double amount = currencyConverterService.convertCurrency("USD", "AED", 200);
        System.out.println(amount);



    }
}
