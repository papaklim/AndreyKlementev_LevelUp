package ru.levelup.andrey.klementev.qa.homework_3.unittest.functions.arithmetic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelup.andrey.klementev.qa.homework_3.unittest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Multiplication Tests")
public class MultiplicationTest extends BaseTest {

    @DisplayName("[Operation: Multiplication. Type: long]")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#multLongData")
    void multLong(long first, long second, long expectedResult) {
        assertEquals(expectedResult, calculator.mult(first, second));
    }

    @DisplayName("[Operation: Multiplication. Type: double]")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#multDoubleData")
    void multDouble(double first, double second, double expectedResult) {
        assertEquals(expectedResult, calculator.mult(first, second), DELTA);
    }
}