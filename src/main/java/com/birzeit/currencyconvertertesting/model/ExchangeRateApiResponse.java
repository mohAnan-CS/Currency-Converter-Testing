package com.birzeit.currencyconvertertesting.model;

import lombok.Data;

@Data
public class ExchangeRateApiResponse {

    private boolean result;
    private double conversionRate;


}

