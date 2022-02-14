package com.corpfield.votingRegistration.utils;

public class Queryutils {
        public static long convertObjToLong(Object obj){
            if(obj==null){
                return 0;
            }
            else {
                return Long.parseLong(String.valueOf(obj));
            }
        }
        public static String convertObjToString(Object obj){
            if(obj==null){
                return "";
            }
            else {
                return String.valueOf(obj);
            }
        }
    }


