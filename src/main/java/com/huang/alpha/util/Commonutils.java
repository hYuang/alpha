package com.huang.alpha.util;

public class Commonutils {
    public static boolean isEmptyOrNull(String  value){

        if(value != null ){
            String pasreValue = value.trim();
            if(pasreValue.length() > 0 ){
                return true;
            }
        }
        return false;
    }
}
