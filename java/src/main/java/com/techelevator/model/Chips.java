package com.techelevator.model;

import java.math.BigDecimal;

public class Chips extends Products{
    public Chips(String code, String name, BigDecimal price, String type) {
        super(code, name, price, type);
    }

    @Override
    public void updateQuantity() {
        quantity = quantity -1;
    }

    @Override
    public String getMessage() {
        return "Crunch Crunch, Yum!";
    }
}
