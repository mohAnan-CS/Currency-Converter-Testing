package com.birzeit.currencyconvertertesting.controller;

import com.birzeit.currencyconvertertesting.model.ConversionRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/converter")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
public class CurrencyConverterController {

    @PostMapping("/convert")
    public ConversionRequest convertCurrency(@RequestBody ConversionRequest request) {

        System.out.println("convertCurrency() is invoked");

        String fromCurrency = request.getFromCurrency();
        String toCurrency = request.getToCurrency();
        double amount = request.getAmount();

        System.out.println("from currency: " + fromCurrency);
        System.out.println("to currency: " + toCurrency);
        System.out.println("amount: " + amount);

        return request;
    }
}
