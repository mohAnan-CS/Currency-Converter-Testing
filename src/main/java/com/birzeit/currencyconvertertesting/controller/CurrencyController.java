package com.birzeit.currencyconvertertesting.controller;

import com.birzeit.currencyconvertertesting.model.Currency;
import com.birzeit.currencyconvertertesting.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CurrencyController {

    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping
    public ResponseEntity<String> saveCurrency(@RequestBody Currency currency) {
        currencyService.save(currency);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Currency>> getAllCurrencies() {
        List<Currency> currencies = currencyService.getAllCurrencies();
        return ResponseEntity.status(HttpStatus.OK).body(currencies);
    }

}
