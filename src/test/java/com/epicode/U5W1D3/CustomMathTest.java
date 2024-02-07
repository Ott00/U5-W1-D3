package com.epicode.U5W1D3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomMathTest {

    @Test
    public void testSum() {
        int result = CustomMath.sum(2, 8);
        assertEquals(10, result);
    }

    @Test
    public void testArraySum() {
        int result = CustomMath.sum(new int[]{1, 2, 3, 4});
        assertEquals(10, result);
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 2", "2, 2, 4", "3, 4, 7", "5, 5, 10"})
    public void testParameterizedSum(int add1, int add2, int expectedResult) {
        int result = CustomMath.sum(add1, add2);
        assertEquals(expectedResult, result);
    }
}
