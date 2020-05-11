package ru.levelup.andrey.klementev.qa.homework_3.unittest.functions.trigonometric;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelup.andrey.klementev.qa.homework_3.unittest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tangent Tests")
public class TgTest extends BaseTest {

    @DisplayName("[Operation: Tangent. Type: double]")
    @ParameterizedTest(name = "tg({0}) = {1}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#tgDoubleData")
    void tgDouble(double first, double expectedResult) {
        assertEquals(expectedResult, calculator.tg(first), DELTA);
    }
}
