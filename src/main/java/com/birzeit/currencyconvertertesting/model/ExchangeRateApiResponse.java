package com.birzeit.currencyconvertertesting.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ExchangeRateApiResponse {

    private boolean result;
    private double conversionRate;

}

