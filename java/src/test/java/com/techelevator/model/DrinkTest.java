package com.techelevator.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DrinkTest {

    @Test
    public void getMessage_pass_in_C1_return_glug_glug_Yum() {
        Drink drinkTest = new Drink("C1", "Cola", BigDecimal.valueOf(1.25), "Drink");
        Assert.assertEquals("Glug Glug, Yum!", drinkTest.getMessage());

    }
    @Test
    public void getMessage_pass_in_C2_return_glug_glug_Yum() {
        Drink drinkTest2 = new Drink("C2", "Dr. Salt", BigDecimal.valueOf(1.50), "Drink");
        Assert.assertEquals("Glug Glug, Yum!", drinkTest2.getMessage());

    }
    @Test
    public void getMessage_pass_in_C3_return_glug_glug_Yum() {
        Drink drinkTest3 = new Drink("C3", "Mountain Melter", BigDecimal.valueOf(1.50), "Drink");
        Assert.assertEquals("Glug Glug, Yum!", drinkTest3.getMessage());

    }
}