package com.birzeit.currencyconvertertesting.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ConversionResponse {

    private double result;
    private double exchangeRate;

}
