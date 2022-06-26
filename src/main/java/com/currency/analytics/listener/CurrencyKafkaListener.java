package com.currency.analytics.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CurrencyKafkaListener {

  @KafkaListener(topics = "${kafka.topic.currency.conversion}")
  public void consume(String msg) {
    log.info("Received message:{}", msg);
  }
}
