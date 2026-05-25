package com.example.crypto.model;

import java.math.BigDecimal;

public class Crypto {
    private Integer id;
    private String name;
    private String symbol;
    private BigDecimal price;
    private BigDecimal quantity;

    public Crypto() {}

    // konstruktor

    public Crypto(Integer id, String name, String symbol, BigDecimal price, BigDecimal quantity) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
    }

    // getter & setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
