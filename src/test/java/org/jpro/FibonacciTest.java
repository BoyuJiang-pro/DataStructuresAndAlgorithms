package org.jpro;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test(timeout = 10)
    public void fib() {
        assertEquals(0, Fibonacci.fib(0));
        assertEquals(1, Fibonacci.fib(1));
        assertEquals(1, Fibonacci.fib(2));
        assertEquals(2, Fibonacci.fib(3));
        assertEquals(55, Fibonacci.fib(10));
    }

    @Test(timeout = 10)
    public void fib2() {
        assertEquals(0, Fibonacci.fib2(0));
        assertEquals(1, Fibonacci.fib2(1));
        assertEquals(1, Fibonacci.fib2(2));
        assertEquals(2, Fibonacci.fib2(3));
        assertEquals(55, Fibonacci.fib2(10));
    }

}