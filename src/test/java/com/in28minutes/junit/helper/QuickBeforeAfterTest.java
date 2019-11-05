package com.in28minutes.junit.helper;

import org.junit.*;

public class QuickBeforeAfterTest {

    @BeforeClass
    public static void setupBefore(){
        System.out.println("before test");
    }

    @AfterClass
    public static void setupAfter(){
        System.out.println("after test");
    }

    @Test
    public void test1(){
        System.out.println("test 1 executed");
    }

    @Test
    public void test2(){
        System.out.println("test 2 executed");
    }
}
