package ru.levelup.andrey.klementev.qa.homework_3.unittest;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    public double DELTA = 0.001;

    public static Calculator calculator;

    @BeforeAll
    static void initCalculatorInstance() {
        calculator = new Calculator();
    }

    @AfterAll
    static void terminateCalculatorInstance() {
        calculator = null;
    }

}
