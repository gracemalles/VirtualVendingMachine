package com.techelevator.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CandyTest {

    @Test
    public void getMessage_pass_in_B1_return_Munch_Munch_Yum() {

        Candy candyTest = new Candy("B1", "Moonpie", BigDecimal.valueOf(1.80), "Candy");
        Assert.assertEquals("Munch Munch, Yum!", candyTest.getMessage());
    }

    @Test
    public void getMessage_pass_in_B2_return_Munch_Munch_Yum() {
        Candy candyTest2 = new Candy("B2", "Cowtales", BigDecimal.valueOf(1.50), "Candy");
        Assert.assertEquals("Munch Munch, Yum!", candyTest2.getMessage());
    }

    @Test
    public void getMessage_pass_in_B3_return_Munch_Munch_Yum() {
        Candy candyTest3 = new Candy("B3", "Wonka Bar", BigDecimal.valueOf(1.50), "Candy");
        Assert.assertEquals("Munch Munch, Yum!", candyTest3.getMessage());

    }
}