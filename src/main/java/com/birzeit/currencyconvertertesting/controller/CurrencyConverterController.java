package com.birzeit.currencyconvertertesting.controller;

import com.birzeit.currencyconvertertesting.model.ConversionRequest;
import com.birzeit.currencyconvertertesting.model.ConversionResponse;
import com.birzeit.currencyconvertertesting.service.CurrencyConverterService;
import com.birzeit.currencyconvertertesting.service.ExchangeRateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/converter")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
public class CurrencyConverterController {

    @PostMapping("/convert")
    public ResponseEntity<ConversionResponse> convertCurrency(@RequestBody ConversionRequest request) throws IOException {
        // Retrieve input values from the request
        String fromCurrency = request.getFromCurrency();
        String toCurrency = request.getToCurrency();
        double amount = request.getAmount();

        CurrencyConverterService currencyConverterService = new CurrencyConverterService();
        ExchangeRateService exchangeRateService = new ExchangeRateService();

        // Perform the currency conversion logic and calculate the result and exchange rate
        // Replace the following lines with your actual conversion logic
        double result = currencyConverterService.convert(fromCurrency, toCurrency, amount);
        double exchangeRate = exchangeRateService.getExchangeRate(fromCurrency, toCurrency);
        System.out.println("Result : " + result);
        System.out.println("Exchange Rate : " + exchangeRate);

        // Create a ConversionResponse object with the result and exchange rate
        ConversionResponse response = new ConversionResponse();
        response.setResult(result);
        response.setExchangeRate(exchangeRate);

        // Return the response with a success status code
        return ResponseEntity.ok(response);
    }
}
