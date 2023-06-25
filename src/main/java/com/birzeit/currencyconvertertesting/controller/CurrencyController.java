package com.birzeit.currencyconvertertesting.controller;

import com.birzeit.currencyconvertertesting.model.Currency;
import com.birzeit.currencyconvertertesting.repository.CurrencyRepository;
import com.birzeit.currencyconvertertesting.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;

public class CurrencyController {

    public static void main(String[] args) {

        CurrencyController currencyController = new CurrencyController();
        currencyController.saveCurrency(new Currency("AED", "UAE Dirham", "United Arab Emirates"));


    }

    @Autowired
    private CurrencyService currencyService;

    public void saveCurrency(Currency currency) {
        currencyService.saveCurrency(currency);
    }
}
