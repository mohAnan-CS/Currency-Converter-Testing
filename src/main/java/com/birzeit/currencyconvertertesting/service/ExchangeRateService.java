package com.birzeit.currencyconvertertesting.service;

import com.birzeit.currencyconvertertesting.model.ExchangeRateApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.Set;
import org.json.JSONObject;  // For JSON-java library‏

@Service
public class ExchangeRateService {

    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/26e3b2de85345b498cde5237";

    public double getExchangeRate(String fromCurrency, String toCurrency ) throws IOException {

        //Check fromCurrency is Null
        if (fromCurrency == null) {
            throw new IllegalArgumentException("fromCurrency is null or empty");
        }

        else if (fromCurrency.isEmpty()) {
            throw new IllegalArgumentException("fromCurrency is null or empty");
        }

        //Check toCurrency is Null
        else if (toCurrency == null) {
            throw new IllegalArgumentException("toCurrency is null or empty");
        }

        else if (toCurrency.isEmpty()) {
            throw new IllegalArgumentException("toCurrency is null or empty");
        }

        else {

            if (fromCurrency.trim().equals(toCurrency)) {
                return 1.0;
            }

            String url = BASE_URL + "/pair/" + fromCurrency.trim() + "/" + toCurrency.trim();

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {

                URL apiURL = new URL(url);
                connection = (HttpURLConnection) apiURL.openConnection();
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {

                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String response = reader.readLine();

                    JSONObject json = new JSONObject(response);

                    return json.getDouble("conversion_rate");

                } else {

                    throw new IOException("Request failed with response code: " + responseCode);

                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (connection != null) {
                    connection.disconnect();
                }
            }
        }
        return 0.0;
    }
}
