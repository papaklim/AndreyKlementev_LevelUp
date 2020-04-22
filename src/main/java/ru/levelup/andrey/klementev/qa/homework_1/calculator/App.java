package ru.levelup.andrey.klementev.qa.homework_1.calculator;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        Calculator calculator = new Calculator(new Values(), new Summator(), new Subtractor(), new Multiplier(),
                new PowRaiser(), new Factorial(), new Fibonacci());
        calculator.start();

    }
}
