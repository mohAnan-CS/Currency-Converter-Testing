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

    public void saveCurrency(Currency currency) {
        currencyRepository.save(currency);
    }

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

}

