package ru.levelup.andrey.klementev.qa.homework_1.calculator;

import java.io.IOException;

public class Calculator {

    private static final String FIRST_VALUE = "Input first value: ";
    private static final String SECOND_VALUE = "Input second value: ";
    private static final String POW_VALUE = "Input pow value: ";
    private static final String FAC_VALUE = "Input factorial value: ";
    private static final String FIB_VALUE = "Input fibonacci value: ";

    private final Values values;
    private final Summator summator;
    private final Subtractor subtractor;
    private final Multiplier multiplier;
    private final PowRaiser powRaiser;
    private final Factorial factorial;
    private final Fibonacci fibonacci;

    public Calculator(Values values, Summator summator, Subtractor subtractor, Multiplier multiplier,
                      PowRaiser powRaiser, Factorial factorial, Fibonacci fibonacci) {
        this.values = values;
        this.summator = summator;
        this.subtractor = subtractor;
        this.multiplier = multiplier;
        this.powRaiser = powRaiser;
        this.factorial = factorial;
        this.fibonacci = fibonacci;
    }

    public void start() throws IOException {

        while (true) {
            System.out.print("Input operation type, like SUM, SUB, MUL, POW, FAC, FIB or EXIT: ");
            String actionValue = values.getAction();
            ActionType action = ActionType.getAction(actionValue);
            switch (action) {
                case SUM:
                    double sumResult = summator.summation(values.getDoubleValue(FIRST_VALUE),
                            values.getDoubleValue(SECOND_VALUE));
                    System.out.println("Result of the summation: " + sumResult);
                    break;
                case SUB:
                    int subResult = subtractor.subtraction(values.getIntValue(FIRST_VALUE),
                            values.getIntValue(SECOND_VALUE));
                    System.out.println("Result of the subtraction: " + subResult);
                    break;
                case MUL:
                    double mulResult = multiplier.multiplication(values.getDoubleValue(FIRST_VALUE),
                            values.getDoubleValue(SECOND_VALUE));
                    System.out.println("Result of the multiplication: " + mulResult);
                    break;
                case POW:
                    double powResult = powRaiser.pow(values.getDoubleValue(FIRST_VALUE),
                            values.getIntValue(POW_VALUE));
                    System.out.println("Result of raising to the power: " + powResult);
                    break;
                case FAC:
                    int facResult = factorial.factorial(values.getIntValue(FAC_VALUE));
                    System.out.println("Result of the factorial calculation: " + facResult);
                    break;
                case FIB:
                    long fibResult = fibonacci.fibonacci(values.getIntValue(FIB_VALUE));
                    System.out.println("Result of the fibonacci: " + fibResult);
                    break;
                case EXIT:
                    values.closeInput();
                    return;
                case UNKNOWN:
                    System.out.println("Incorrect input. Try again.");
            }
        }
    }
}
