package com.spartaglobal.alpari;


import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


public class RatesDTO {

    private JSONObject fullRatesFile;

    public RatesDTO(String filePath){

        RatesFileReader ratesFile = new RatesFileReader(filePath);
        JSONParser parser = new JSONParser();

        try{
            Object ratesObj = parser.parse(ratesFile.getRatesFile());
            fullRatesFile = (JSONObject) ratesObj;
        }catch (ParseException | IOException e){
            e.printStackTrace();
        }

    }
    private JSONObject getFullRatesFile(){
        return fullRatesFile;
    }
    // debugging method
    public void printRate(){
        System.out.println(fullRatesFile.toString());
    }

    //locked accessors
    public long getTimestamp(){
        return (long) fullRatesFile.get("timestamp");
    }

    //accessors
    public boolean getSuccessValue(){
        return (boolean) fullRatesFile.get("success");
    }

    public String convertEpochToDate(){
        Date date = new Date(getTimestamp()*1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public String getBase(){
        return (String) fullRatesFile.get("base");
    }

    //get embedded rates
    public JSONObject getAllRates(){
        return (JSONObject) fullRatesFile.get("rates");
    }

    public double getSpecificRate(String rateCode){
        return (double) getAllRates().get(rateCode);
    }

    // keys
    public Set getRatesKeys(){
        return getAllRates().keySet();
    }

    public Set printCVSFormat(){
        return getAllRates().entrySet();
    }

}
