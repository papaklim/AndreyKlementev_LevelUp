package ru.levelup.andrey.klementev.qa.homework_3.unittest.trigonometric_functions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelup.andrey.klementev.qa.homework_3.unittest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Cotangent Tests")
public class CtgTest extends BaseTest {

    @DisplayName("[Operation: Cotangent. Type: double]")
    @ParameterizedTest(name = "ctg({0}) = {1}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#ctgDoubleData")
    void ctgDouble(double first, double expectedResult) {
        assertEquals(expectedResult, calculator.ctg(first), 0.001);
    }
}
