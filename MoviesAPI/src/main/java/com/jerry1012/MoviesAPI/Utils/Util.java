package com.jerry1012.MoviesAPI.Utils;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public List<String> getAllUnique(List<String> values){

        List<String> uniquesValues = new ArrayList<>();

        for (String value : values) {
            if(value.contains(",")){
                List<String> seperatedValue = getCommaSeperatedValue(value);
                for (String commonSeperateValue : seperatedValue){
                    if(!uniquesValues.contains(commonSeperateValue)){
                        uniquesValues.add(commonSeperateValue);
                    }
                }
            }else{
                if(!uniquesValues.contains(value)){
                    uniquesValues.add(value);
                }
            }
        }

        return uniquesValues;
    }

    public List<String> getCommaSeperatedValue(String value){
        return List.of(value.split(","));
    }

}
