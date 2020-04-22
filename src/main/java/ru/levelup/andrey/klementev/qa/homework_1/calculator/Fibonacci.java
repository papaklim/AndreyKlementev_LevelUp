package ru.levelup.andrey.klementev.qa.homework_1.calculator;

public class Fibonacci {
    public long fibonacci(int n) {

        if (n >= 2) {
            int prevValue = 0;
            int curValue = 1;
            int sumValue;
            int result = 0;
            for (int i = 2; i <= n; i++) {
                sumValue = prevValue + curValue;
                prevValue = curValue;
                curValue = sumValue;
                result = sumValue;
            }
            return result;
        }
        else return n;
    }
}
