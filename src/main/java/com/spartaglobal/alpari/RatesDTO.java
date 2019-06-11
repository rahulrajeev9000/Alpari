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
}
