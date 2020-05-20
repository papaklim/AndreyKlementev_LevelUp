package ru.levelup.andrey.klementev.qa.homework_3.unittest.functions.trigonometric;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelup.andrey.klementev.qa.homework_3.unittest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Sinus Tests")
public class SinTest extends BaseTest {

    @DisplayName("[Operation: Sinus. Type: double]")
    @ParameterizedTest(name = "sin({0}) = {1}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#sinDoubleData")
    void sinDouble(double first, double expectedResult) {
        assertEquals(expectedResult, calculator.sin(first), DELTA);
    }
}
