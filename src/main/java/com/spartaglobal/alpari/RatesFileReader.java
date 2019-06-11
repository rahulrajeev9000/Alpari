package com.spartaglobal.alpari;


import java.io.FileNotFoundException;
import java.io.FileReader;

public class RatesFileReader {

    private FileReader ratesFile;

    public RatesFileReader(String filePath){
        try {
            ratesFile = new FileReader(filePath) ;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public FileReader getRatesFile() {
        return ratesFile;
    }
}
