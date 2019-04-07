package com.calculation.fraction;

import org.junit.*;
import static org.junit.Assert.*;

public class TestFraction {

    private Fraction fraction;

    @Before
    public void initTest() {
        fraction = new Fraction();
    }

    @After
    public void afterTest() {
        fraction = null;
    }

    @Test
    public void test1() throws Exception {
        assertEquals("8", fraction.calculateFraction("(2+2)+(2+2)"));
    }

    @org.junit.Test
    public void test2() throws Exception {
        assertEquals("55", fraction.calculateFraction("55"));
    }

    @org.junit.Test
    public void test3() throws Exception {
        assertEquals("7/6", fraction.calculateFraction("1/2+2/3"));
    }

    @org.junit.Test
    public void test4() throws Exception {
        assertEquals("3/4", fraction.calculateFraction("(3/6)/(2/3)"));
    }

    @org.junit.Test
    public void test5() throws Exception {
        assertEquals("47/-42", fraction.calculateFraction("(1/2+2/3)-((2/7)/(1/8))"));
    }

    @org.junit.Test
    public void test6() throws Exception {
        assertEquals("3/2", fraction.calculateFraction("1+1/2"));
    }

    @org.junit.Test
    public void test7() throws Exception {
        assertEquals("3/7", fraction.calculateFraction("(3/7*4/8)/(1/2)"));
    }

    @org.junit.Test
    public void test8() throws Exception {
        assertEquals("-43/28", fraction.calculateFraction("5/7-9/4"));
    }
    @org.junit.Test
    public void test9() throws Exception {
        assertEquals("7/2", fraction.calculateFraction("(-5/4+3)*((1/7)/(2/28))"));
    }
    @org.junit.Test
    public void test10() throws Exception {
        assertEquals("0", fraction.calculateFraction("2+3-5"));
    }
}
