package ru.levelup.andrey.klementev.qa.homework_3.unittest.arithmetic_functions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelup.andrey.klementev.qa.homework_3.unittest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Pow raising Tests")
public class PowTest extends BaseTest {

    @DisplayName("[Operation: Pow. Type: double]")
    @ParameterizedTest(name = "{0} ^ {1} = {2}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#powDoubleData")
    void powDouble(double first, double second, double expectedResult) {
        assertEquals(expectedResult, calculator.pow(first, second), 0.001);
    }
}
