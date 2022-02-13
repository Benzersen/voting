package com.corpfield.votingRegistration.utils;

public class Queryutils {
        public static long convertObjtoLong(Object obj){
            if(obj==null){
                return 0;
            }
            else {
                return Long.parseLong(String.valueOf(obj));
            }
        }
        public static String convertObjtoString(Object obj){
            if(obj==null){
                return "";
            }
            else {
                return String.valueOf(obj);
            }
        }
    }


