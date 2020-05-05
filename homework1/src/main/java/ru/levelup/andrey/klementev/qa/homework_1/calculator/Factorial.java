package ru.levelup.andrey.klementev.qa.homework_1.calculator;

public class Factorial {

    public int factorial(int a) {
        int result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }
}
