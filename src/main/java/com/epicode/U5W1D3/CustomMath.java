package com.epicode.U5W1D3;

public class CustomMath {
    static public int sum(int a, int b) {
        return a + b;
    }

    static public int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
