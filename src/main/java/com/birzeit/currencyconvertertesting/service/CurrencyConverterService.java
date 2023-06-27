package com.birzeit.currencyconvertertesting.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CurrencyConverterService {

    ExchangeRateService exchangeRateService = new ExchangeRateService();

    public double convert(String fromCurrency, String toCurrency, double amount) throws IOException {

        checkInputValidation(fromCurrency, toCurrency, amount);
        checkCurrencies(fromCurrency, toCurrency);

        double exchangeRate = exchangeRateService.getExchangeRate(fromCurrency, toCurrency);
        checkExchangeRate(exchangeRate);

        return amount * exchangeRate;

    }

    private void checkCurrencies(String fromCurrency, String toCurrency) {



    }

    public void checkExchangeRate(double exchangeRate) {

        if (exchangeRate == 0) {
            throw new IllegalArgumentException("exchangeRate is zero");
        }

        if (exchangeRate < 0) {
            throw new IllegalArgumentException("exchangeRate is negative");
        }


    }

    public boolean checkInputValidation(String fromCurrency, String toCurrency, Double amount) {

        if (fromCurrency == null || fromCurrency.isEmpty()) {
            throw new IllegalArgumentException("fromCurrency is null or empty");
        }

        if (toCurrency == null || toCurrency.isEmpty()) {
            throw new IllegalArgumentException("toCurrency is null or empty");
        }

        if (amount < 0) {
            throw new IllegalArgumentException("amount is negative");
        }

        if (amount == 0) {
            throw new IllegalArgumentException("amount is zero");
        }

        if (fromCurrency.matches(".*\\d.*")) {
            throw new IllegalArgumentException("fromCurrency contains digit");
        }

        if (toCurrency.matches(".*\\d.*")) {
            throw new IllegalArgumentException("toCurrency contains digit");
        }

        return true;

    }


}
