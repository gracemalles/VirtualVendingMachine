package com.techelevator.model;

import java.math.BigDecimal;
import java.util.List;

public abstract class Products  {

    private String code;
    private String name;
    private BigDecimal price;
    private String type;
    protected int quantity;


    public Products(String code, String name, BigDecimal price, String type) {
        this.code =  code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = 5;

    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract void updateQuantity();

    public abstract String getMessage();




}

