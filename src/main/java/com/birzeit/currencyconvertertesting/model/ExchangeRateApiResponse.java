package com.birzeit.currencyconvertertesting.model;

public class ExchangeRateApiResponse {

    private boolean result;
    private double conversionRate;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }


    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }



}

