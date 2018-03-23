package com.spring.wvk.utils;


import java.util.Random;

public class KeyUtil {
    public static synchronized String genUniqueKey(){
        Random random = new Random();

        Integer a = random.nextInt(90000)+10000;

        return System.currentTimeMillis() + String.valueOf(a);
    }
}
