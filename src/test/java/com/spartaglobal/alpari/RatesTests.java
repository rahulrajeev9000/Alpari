package com.spartaglobal.alpari;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RatesTests {

    RatesDTO rates;

    @Before
    public  void setup(){
        rates = new RatesDTO("resources/rates.json");
    }

    @Test
    public void testSucessResponse(){
        Assert.assertTrue(rates.getSuccessValue());
    }
}
