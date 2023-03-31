package com.demoqa;

import org.junit.jupiter.api.*;

public class FirstJUnitTest {
    @BeforeEach
    void BeforeEach(){
        System.out.println("Try @BeforeEach");
    }
    @AfterEach
    void AfterEach(){
        System.out.println("Try @AfterEach");
    }
    @BeforeAll
    static void BeforeAll(){
        System.out.println("Try @BeforeAll");
    }
    @AfterAll
    static void AfterAll(){
        System.out.println("Try @AfterAll");
    }


    @Test
    void firstTest(){
        Assertions.assertTrue(3>2);
        System.out.println(" ##### Test");
    }
    @Test
    void firstTest2(){
        Assertions.assertTrue(3>2);
        System.out.println(" ##### Test2");
    }
    @Test
    void firstTest3(){
        Assertions.assertTrue(3>2);
        System.out.println(" ##### Test3");
    }
}
