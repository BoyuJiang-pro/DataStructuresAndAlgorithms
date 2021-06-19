package org.jpro.utils;

import org.jpro.Fibonacci;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeToolsTest {

    @Test
    public void check() {
        TimeTools.check("fib", () -> Fibonacci.fib(5));
    }
}