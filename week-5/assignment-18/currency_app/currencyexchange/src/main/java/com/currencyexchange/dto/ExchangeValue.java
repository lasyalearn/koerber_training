package com.currencyexchange.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exchange_value")
public class ExchangeValue
{
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;
    @Column(name = "port")
    private Integer port;
    public ExchangeValue(String from, String to, BigDecimal conversionMultiple)
    {
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

}
