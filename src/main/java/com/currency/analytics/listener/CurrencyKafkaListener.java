package com.currency.analytics.listener;

import com.currency.analytics.model.CurrencyConversion;
import com.currency.analytics.service.CurrencyConversionElasticRepositoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class CurrencyKafkaListener {
  @Autowired
  private ObjectMapper mapper;

  @Autowired
  private CurrencyConversionElasticRepositoryService service;

  @KafkaListener(topics = "${kafka.topic.currency.conversion}")
  public void consume(String msg) {
    log.info("Received message:{}", msg);
    CurrencyConversion currencyConversion = null;
    try {
      currencyConversion = mapper.readValue(msg, CurrencyConversion.class);
      currencyConversion.setConversionId(currencyConversion.getId());
      currencyConversion.setId(UUID.randomUUID().toString());

    } catch (Exception e) {
      log.error("Error in parsing kafka message.", e);
    }
    service.saveCurrencyConversion(currencyConversion);
    log.info("Stored data to elasticsearch successfully.");
  }
}
