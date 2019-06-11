package com.spartaglobal.alpari;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        Date date = new Date(rates.getTimestamp()*1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);
        Assert.assertEquals("2018-10-10",formattedDate);

    }

    @Test
    public void testBase(){
        Assert.assertEquals("EUR", rates.getBase());
    }


}
