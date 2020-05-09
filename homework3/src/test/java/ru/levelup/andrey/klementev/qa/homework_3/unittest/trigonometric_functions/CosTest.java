package ru.levelup.andrey.klementev.qa.homework_3.unittest.trigonometric_functions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelup.andrey.klementev.qa.homework_3.unittest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Cosinus Tests")
public class CosTest extends BaseTest {

    @DisplayName("[Operation: Cosinus. Type: double]")
    @ParameterizedTest(name = "cos({0}) = {1}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#cosDoubleData")
    void cosDouble(double first, double expectedResult) {
        assertEquals(expectedResult, calculator.cos(first), 0.001);
    }
}
