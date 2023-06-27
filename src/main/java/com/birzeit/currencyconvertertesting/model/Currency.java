package com.birzeit.currencyconvertertesting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    @Id
    private String currencyCode;

    private String currencyName;

    private String country;

}
