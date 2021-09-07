package com.techelevator.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChipsTest {

    @Test
    public void getMessage_pass_in_A1_return_Crunch_Crunch_Yum() {
        Chips chipsTest =  new Chips("A1", "Potato Crisps", BigDecimal.valueOf(3.05),"Chips");
        Assert.assertEquals("Crunch Crunch, Yum!", chipsTest.getMessage() );
    }
    @Test
    public void getMessage_pass_in_A2_return_Crunch_Crunch_Yum() {
        Chips chipsTest2 =  new Chips("A2", "Stackers", BigDecimal.valueOf(1.45),"Chips");
        Assert.assertEquals("Crunch Crunch, Yum!", chipsTest2.getMessage() );
    }
    @Test
    public void getMessage_pass_in_A3_return_Crunch_Crunch_Yum() {
        Chips chipsTest3 =  new Chips("A3", "Grain Waves", BigDecimal.valueOf(2.75),"Chips");
        Assert.assertEquals("Crunch Crunch, Yum!", chipsTest3.getMessage() );
    }
}

