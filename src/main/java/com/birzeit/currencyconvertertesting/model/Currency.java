package com.birzeit.currencyconvertertesting.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Data
public class Currency {

    @Id
    private String currencyCode;

    private String currencyName;


    private String country;

}
