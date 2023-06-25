package com.birzeit.currencyconvertertesting.repository;

import com.birzeit.currencyconvertertesting.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {
    // Additional custom methods can be defined here if needed


}

