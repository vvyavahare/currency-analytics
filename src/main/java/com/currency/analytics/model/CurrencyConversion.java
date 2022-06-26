package com.currency.analytics.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@ToString
@Data
@Document(indexName = "currency-conversion-index")
public class CurrencyConversion {
  @Id
  private String id;

  @Field(type = FieldType.Text, name = "conversion_id")
  private String conversionId;
  @Field(type = FieldType.Text, name = "from")
  private String from;
  @Field(type = FieldType.Text, name = "to")
  private String to;
  @Field(type = FieldType.Long, name = "quantity")
  private BigDecimal quantity;
  @Field(type = FieldType.Long, name = "conversionMultiple")
  private BigDecimal conversionMultiple;
  @Field(type = FieldType.Long, name = "totalCalculatedAmount")
  private BigDecimal totalCalculatedAmount;
  @Field(type = FieldType.Text, name = "environment")
  private String environment;
}