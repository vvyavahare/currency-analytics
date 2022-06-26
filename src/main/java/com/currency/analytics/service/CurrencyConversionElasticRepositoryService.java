package com.currency.analytics.service;

import com.currency.analytics.model.CurrencyConversion;
import com.currency.analytics.repository.CurrencyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CurrencyConversionElasticRepositoryService {

  @Autowired
  private CurrencyRepository repository;

  public void saveCurrencyConversion(final CurrencyConversion currencyConversion) {
    /**
     * ToDo: Handle Exception gracefully.
     */
//    try {
      log.info("Saving Currency Conversion Info:{}", currencyConversion);
      CurrencyConversion c = repository.save(currencyConversion);
      log.info("Saved, {}", c);
//    } catch (Exception e) {
//      log.error("Error in saving data to elasticsearch.", e);
//    }

  }
}
