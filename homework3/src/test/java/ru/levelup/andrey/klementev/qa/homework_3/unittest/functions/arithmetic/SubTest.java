package ru.levelup.andrey.klementev.qa.homework_3.unittest.functions.arithmetic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelup.andrey.klementev.qa.homework_3.unittest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Subtraction Tests")
public class SubTest extends BaseTest {

    @DisplayName("[Operation: Subtraction. Type: long]")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#subLongData")
    void subLong(long first, long second, long expectedResult) {
        assertEquals(expectedResult, calculator.sub(first, second), DELTA);
    }

    @DisplayName("[Operation: Subtraction. Type: double]")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#subDoubleData")
    void subDouble(double first, double second, double expectedResult) {
        assertEquals(expectedResult, calculator.sub(first, second), DELTA);
    }
}
