package com.spartaglobal.alpari;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RatesTests {

    private static RatesDTO rates;

    @BeforeClass
    public static void setup(){
        rates = new RatesDTO("resources/rates.json");
    }

    @Test
    public void testSuccessResponse(){
        Assert.assertTrue(rates.getSuccessValue());
    }

    @Test
    public void testTimestamp(){
        Assert.assertEquals("2018-10-10",rates.convertEpochToDate());
    }

    @Test
    public void testBase(){
        Assert.assertEquals("EUR", rates.getBase());
    }

    @Test
    public void numberOfCurrencies(){
        Assert.assertEquals(168, rates.getAllRates().size());
    }

    @Test
    public void testCVS(){
        String[] ratesArray = rates.printCVSFormat().toString().split(",");
        boolean csv = false;
        for (int i =0; i<ratesArray.length; i++){
            if (ratesArray[i].equals(" AED=4.234904")){
                 csv = true;
            }
        }
        Assert.assertEquals(true, csv);
    }


}
