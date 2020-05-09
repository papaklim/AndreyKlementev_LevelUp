package ru.levelup.andrey.klementev.qa.homework_3.unittest.arithmetic_functions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelup.andrey.klementev.qa.homework_3.unittest.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Sqrt Tests")
public class SqrtTest extends BaseTest {

    @DisplayName("[Operation: Sqrt. Type: double]")
    @ParameterizedTest(name = "√ {0} = {1}")
    @MethodSource("ru.levelup.andrey.klementev.qa.homework_3.unittest.DataProvider#sqrtDoubleData")
    void sqrtDouble(double first, double expectedResult) {
        assertEquals(expectedResult, calculator.sqrt(first), 0.001);
    }
}
