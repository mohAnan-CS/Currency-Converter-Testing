package com.birzeit.currencyconvertertesting;

import com.birzeit.currencyconvertertesting.model.Currency;
import com.birzeit.currencyconvertertesting.repository.CurrencyRepository;
import com.birzeit.currencyconvertertesting.service.CurrencyConverterService;
import com.birzeit.currencyconvertertesting.service.CurrencyService;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {

        CurrencyService currencyService = new CurrencyService();
        currencyService.save(new Currency("AED", "UAE Dirham", "United Arab Emirates"));

    }
}
