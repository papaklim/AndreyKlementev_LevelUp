package ru.levelup.andrey.klementev.qa.homework_3.unittest.arithmetic_functions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelup.andrey.klementev.qa.homework_3.unittest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Check sign number Tests")
public class CheckSignNumberTest extends BaseTest {

    @DisplayName("[Operation: isPositive. Type: long]")
    @ParameterizedTest(name = " {0} = {1}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#PositiveLongData")
    void isPositiveLong(long first, boolean expectedResult) {
        assertEquals(expectedResult, calculator.isPositive(first));
    }

    @DisplayName("[Operation: isNegative. Type: long]")
    @ParameterizedTest(name = " {0} = {1}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#NegativeLongData")
    void isNegativeLong(long first, boolean expectedResult) {
        assertEquals(expectedResult, calculator.isNegative(first));
    }
}
