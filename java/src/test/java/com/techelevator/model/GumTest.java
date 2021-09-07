package com.techelevator.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GumTest {

    @Test
    public void getMessage_pass_in_D1_return_Chew_Chew_Yum() {
        Gum gumTest = new Gum("D1", "U-Chews", BigDecimal.valueOf(0.85), "Gum");
        Assert.assertEquals("Chew Chew, Yum!", gumTest.getMessage());

    }
    @Test
    public void getMessage_pass_in_D2_return_Chew_Chew_Yum() {
        Gum gumTest2 = new Gum("D2", "Little League Chew", BigDecimal.valueOf(0.95), "Gum");
        Assert.assertEquals("Chew Chew, Yum!", gumTest2.getMessage());

    }
    @Test
    public void getMessage_pass_in_D3_return_Chew_Chew_Yum() {
        Gum gumTest3 = new Gum("D3", "Chiclets", BigDecimal.valueOf(0.75), "Gum");
        Assert.assertEquals("Chew Chew, Yum!", gumTest3.getMessage());

    }
}