package com.birzeit.currencyconvertertesting.service;

import com.birzeit.currencyconvertertesting.model.Currency;
import com.birzeit.currencyconvertertesting.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public boolean save(Currency currency) {

        if (currency == null) {
            throw new IllegalArgumentException("currency is null");
        }

        else if (currency.getCurrencyName() == null ){
            throw new IllegalArgumentException("currencyName is null");
        }

        else if (currency.getCurrencyName().isEmpty()){
            throw new IllegalArgumentException("currencyName is empty");
        }

        else if (currency.getCurrencyCode() == null ){
            throw new IllegalArgumentException("currencyCode is null");
        }

        else if (currency.getCurrencyCode().isEmpty()){
            throw new IllegalArgumentException("currencyCode is empty");
        }

        else if (currency.getCountry() == null ){
            throw new IllegalArgumentException("country is null");
        }

        else if (currency.getCountry().isEmpty()){
            throw new IllegalArgumentException("country is empty");
        }

        //Check if the currency code length is equal to 3
        else if (currency.getCurrencyCode().length() != 3){
            throw new IllegalArgumentException("currencyCode length is not equal to 3");
        }

        else {
            currencyRepository.save(currency);
            return true;
        }


    }

    public void saveAll(List<Currency> currencies) {
        currencyRepository.saveAll(currencies);
    }

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

}

