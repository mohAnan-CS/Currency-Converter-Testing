package com.birzeit.currencyconvertertesting.controller;

import com.birzeit.currencyconvertertesting.model.ConversionRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/converter")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
public class CurrencyConverterController {

    @PostMapping("/convert")
    public ResponseEntity<ConversionResponse> convertCurrency(@RequestBody ConversionRequest request) {
        // Retrieve input values from the request
        String fromCurrency = request.getFromCurrency();
        String toCurrency = request.getToCurrency();
        double amount = request.getAmount();

        // Perform the currency conversion logic and calculate the result and exchange rate
        // Replace the following lines with your actual conversion logic
        double result = performConversion(fromCurrency, toCurrency, amount);
        double exchangeRate = getExchangeRate(fromCurrency, toCurrency);

        // Create a ConversionResponse object with the result and exchange rate
        ConversionResponse response = new ConversionResponse();
        response.setResult(result);
        response.setExchangeRate(exchangeRate);

        // Return the response with a success status code
        return ResponseEntity.ok(response);
    }
}
