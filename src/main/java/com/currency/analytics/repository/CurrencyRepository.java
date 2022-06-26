package com.currency.analytics.repository;

import com.currency.analytics.model.CurrencyConversion;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CurrencyRepository extends ElasticsearchRepository<CurrencyConversion, String> {
}
