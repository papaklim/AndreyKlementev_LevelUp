package ru.levelup.andrey.klementev.qa.homework_3.unittest.arithmetic_functions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelup.andrey.klementev.qa.homework_3.unittest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Division Tests")
public class DivisionTest extends BaseTest {


    @DisplayName("[Operation: Division. Type: long]")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#divLongData")
    void divLong(long first, long second, long expectedResult) {
        assertEquals(expectedResult, calculator.div(first, second));
    }

    @DisplayName("[Operation: Division. Type: double]")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#divDoubleData")
    void divDouble(double first, double second, double expectedResult) {
        assertEquals(expectedResult, calculator.div(first, second));
    }

    @Test
    @DisplayName("[Operation: Division. Type: long. Divider: 0]")
    public void divLongByZero() {
        assertThrows(NumberFormatException.class, () -> calculator.div(6L, 0L),
                "Attempt to divide by zero");
    }

    @Test
    @DisplayName("[Operation: Division. Type: double. Divider: 0]")
    public void divDoubleByZero() {
        assertThrows(NumberFormatException.class, () -> calculator.div(5.55, 0),
                "Attempt to divide by zero");
    }
}
