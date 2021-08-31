package com.springboottest.Utils;

import java.util.Random;

/**
 * user:lufei
 * DATE:2021/8/14
 **/
public class StringUtils {
    public static String getRandomString(int length){
        String base = "ajkdshgfuawfjksafkjahksdfhuiw";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i< length;i++){
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
