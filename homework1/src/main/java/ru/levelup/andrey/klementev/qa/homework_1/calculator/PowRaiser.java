package ru.levelup.andrey.klementev.qa.homework_1.calculator;

public class PowRaiser {
    public double pow(double a, int b) {

        double expResult = 1;
        double negativeExpResult;

        if (b == 0) {
            return a;
        }
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                expResult *= a;
            }
            return expResult;
        }

        int absB = Math.abs(b);
        for (int i = 0; i < absB; i++) {
            expResult *= a;
        }
        negativeExpResult = 1 / expResult;
        return negativeExpResult;
    }
}


