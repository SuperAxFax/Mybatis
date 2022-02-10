package com.kuang.utils;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")
public class IDutils {
    //来获得随机ID
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDutils.getID());
        System.out.println(IDutils.getID());
        System.out.println(IDutils.getID());
    }
}
