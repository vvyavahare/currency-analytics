package com.currency.analytics.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
public class CurrencyKafkaListener {

  @KafkaListener(topics = "${kafka.bootstrap.server}")
  public void consume(String msg) {
    log.info("Received message:{}", msg);
  }
}
