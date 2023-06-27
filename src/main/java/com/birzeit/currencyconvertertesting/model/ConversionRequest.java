package com.birzeit.currencyconvertertesting.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversionRequest {

    private String fromCurrency;
    private String toCurrency;
    private double amount;

}
