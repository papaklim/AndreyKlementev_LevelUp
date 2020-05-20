package ru.levelup.andrey.klementev.qa.homework_3.unittest.functions.arithmetic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelup.andrey.klementev.qa.homework_3.unittest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Summation Tests")
public class SumTest extends BaseTest {

    @DisplayName("[Operation: Summation. Type: long]")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#sumLongData")
    void sumLong(long first, long second, long expectedResult) {
        assertEquals(expectedResult, calculator.sum(first, second));
    }

    @DisplayName("[Operation: Summation. Type: double]")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#sumDoubleData")
    void sumDouble(double first, double second, double expectedResult) {
        assertEquals(expectedResult, calculator.sum(first, second), DELTA);
    }
}
