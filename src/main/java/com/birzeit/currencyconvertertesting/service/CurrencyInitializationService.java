package com.birzeit.currencyconvertertesting.service;

import com.birzeit.currencyconvertertesting.model.Currency;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyInitializationService {

    private final CurrencyService currencyService;

    public CurrencyInitializationService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostConstruct
    public void init() throws IOException {
        System.out.println("Initializing currency data...");
        try {
            List<Currency> currencies = readCurrencyDataFromFile("C:\\Users\\twitter\\IdeaProjects\\CurrencyConverterTesting\\currency.txt");
            currencyService.saveAll(currencies);
        } catch (IOException e) {
            throw new IOException("Error occurred while reading data from file", e);
        }
    }

    public List<Currency> readCurrencyDataFromFile(String filePath) throws IOException {

        try {

            if (filePath == null ) {
                throw new IllegalArgumentException("filePath is null ");
            }

            if (filePath.isEmpty()) {
                throw new IllegalArgumentException("filePath is empty");
            }

            List<Currency> currencies = new ArrayList<>();

            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                count++;
                String[] data = line.split(",");

                Currency currency = new Currency();
                currency.setCurrencyCode(data[0].trim());
                currency.setCurrencyName(data[1].trim());
                currency.setCountry(data[2].trim());

                currencies.add(currency);
            }

            if (count == 0) {
                throw new IllegalArgumentException("There is no currencies, file is empty");
            }

            reader.close();

            return currencies;

        }catch (IOException e) {
            throw new IOException("Error occurred while reading data from file", e);
        }

    }
}

