package com.spartaglobal.alpari;


import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;


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
    public void printRate(){
        System.out.println(fullRatesFile.toString());
    }
    public boolean getSuccessValue(){
        return (boolean) fullRatesFile.get("success");
    }
    public long getTimestamp(){
        return (long) fullRatesFile.get("timestamp");
    }
    public String getBase(){
        return (String) fullRatesFile.get("base");
    }
//    public String[] getRatesArray(){
//        String[] values = fullRatesFile.get("rates").toString().split(",");
//
//        return values;
//    }
//    public double getRate(String currency){
//        double r =0;
//        for (int i=0; i<getRatesArray().size(); i++){
//            if ((double)getRatesArray().get(i) == (double)fullRatesFile.get(currency)){
//                 r = (double)getRatesArray().get(i);
//
//            }
//        }
//        return r;
//    }

}
