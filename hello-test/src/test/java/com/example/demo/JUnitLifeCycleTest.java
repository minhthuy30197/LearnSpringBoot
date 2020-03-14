package com.example.demo;

import org.junit.jupiter.api.*;

public class JUnitLifeCycleTest {
    @BeforeAll
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeAll - runOnceBeforeClass");
    }

    @AfterAll
    public static void runOnceAfterClass() {
        System.out.println("@AfterAll - runOnceAfterClass");
    }

    @BeforeEach
    public void runBeforeTestMethod() {
        System.out.println("@BeforeEach - runBeforeTestMethod");
    }

    @AfterEach
    public void runAfterTestMethod() {
        System.out.println("@AfterEach - runAfterTestMethod");
    }

    @Test
    public void test_method_1() {
        System.out.println("@Test - test_method_1");
    }

    @Test
    public void test_method_2() {
        System.out.println("@Test - test_method_2");
    }
}
