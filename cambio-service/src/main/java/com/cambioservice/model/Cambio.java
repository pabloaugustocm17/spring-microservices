package com.cambioservice.model;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class Cambio implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionFactor;

    private BigDecimal conversionValue;

    private String enviromnet;

    public Cambio(){

    }

    public Cambio(Long id, String from, String to, BigDecimal conversionFactor, BigDecimal conversionValue, String enviromnet) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.conversionValue = conversionValue;
        this.enviromnet = enviromnet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public BigDecimal getConversionValue() {
        return conversionValue;
    }

    public void setConversionValue(BigDecimal conversionValue) {
        this.conversionValue = conversionValue;
    }

    public String getEnviromnet() {
        return enviromnet;
    }

    public void setEnviromnet(String enviromnet) {
        this.enviromnet = enviromnet;
    }
}
