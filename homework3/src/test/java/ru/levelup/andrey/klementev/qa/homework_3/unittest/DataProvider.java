package ru.levelup.andrey.klementev.qa.homework_3.unittest;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProvider {

    public static Stream<Arguments> sumLongData() {
        return Stream.of(
                Arguments.of(0, 3000000000L, 3000000000L),
                Arguments.of(20000000000L, 0, 20000000000L),
                Arguments.of(-20, -10, -30)
        );
    }

    public static Stream<Arguments> sumDoubleData() {
        return Stream.of(
                Arguments.of(0, 2.5, 2.5),
                Arguments.of(3.5, 0, 3.5),
                Arguments.of(49.55, 50.45, 100.0),
                Arguments.of(1.555, 100.222, 101.777),
                Arguments.of(-20.33, -10.11, -30.44)
        );
    }

    public static Stream<Arguments> subLongData() {
        return Stream.of(
                Arguments.of(0, 3000000000L, -3000000000L),
                Arguments.of(20000000000L, 0, 20000000000L),
                Arguments.of(-20, -10, -10)
        );
    }

    public static Stream<Arguments> subDoubleData() {
        return Stream.of(
                Arguments.of(0, 2.5, -2.5),
                Arguments.of(3.5, 0, 3.5),
                Arguments.of(59.55, 50.45, 9.1),
                Arguments.of(5.55, 3.33, 2.22),
                Arguments.of(-20.33, -10.11, -10.22)
        );
    }

    public static Stream<Arguments> divLongData() {
        return Stream.of(
                Arguments.of(3000000000L, 3000000000L, 1L),
                Arguments.of(20000000000L, 1, 20000000000L),
                Arguments.of(-20, -10, 2)
        );
    }

    public static Stream<Arguments> divDoubleData() {
        return Stream.of(
                Arguments.of(2.5, 2.5, 1),
                Arguments.of(3.0, 1.5, 2.0),
                Arguments.of(-20.50, -10.25, 2.0)
        );
    }

    public static Stream<Arguments> multLongData() {
        return Stream.of(
                Arguments.of(3000000000L, 3000000000L, 9000000000000000000L),
                Arguments.of(20000000000L, 1, 20000000000L),
                Arguments.of(-20, -10, 200),
                Arguments.of(30, -2, -60)
        );
    }

    public static Stream<Arguments> multDoubleData() {
        return Stream.of(
                Arguments.of(-2.33, 3.222, -7.507),
                Arguments.of(3.33, -2.222, -7.399),
                Arguments.of(-20.50, -10.25, 210.125)
        );
    }

    public static Stream<Arguments> powDoubleData() {
        return Stream.of(
                Arguments.of(-2.33, 3.222, 15.262), // либо Double.NaN, если тестируется работа метода sqrt класса Math
                Arguments.of(3.33, -2.222, 0.069), // либо Double.NaN, если тестируется работа метода sqrt класса Math?
                Arguments.of(-2.1, -3.2, 0.093), // либо Double.NaN, если тестируется работа метода sqrt класса Math
                Arguments.of(5.5, 0, 1),
                Arguments.of(0, 2.5, 0),
                Arguments.of(-2, -3, -0.125)
        );
    }

    public static Stream<Arguments> sqrtDoubleData() {
        return Stream.of(
                Arguments.of(2.33, 1.526),
                Arguments.of(-3.33, Double.NaN),
                Arguments.of(0, 0),
                Arguments.of(9, 3)
        );
    }

    public static Stream<Arguments> sinDoubleData() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 0.841),
                Arguments.of(-90, -0.893),
                Arguments.of(30.5, -0.793)
        );
    }

    public static Stream<Arguments> cosDoubleData() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0.54),
                Arguments.of(-90, -0.448),
                Arguments.of(30.5, -0.609)
        );
    }

    public static Stream<Arguments> tgDoubleData() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1.557),
                Arguments.of(-90, -1.995),
                Arguments.of(30.5, -1.302)
        );
    }

    public static Stream<Arguments> ctgDoubleData() {
        return Stream.of(
                Arguments.of(0, Double.NaN),
                Arguments.of(1, 0.642),
                Arguments.of(-90, 0.501),
                Arguments.of(30.5, -0.767)
        );
    }

    public static Stream<Arguments> positiveLongData() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(1, true),
                Arguments.of(-5, false)
        );
    }

    public static Stream<Arguments> negativeLongData() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(-5, true)
        );
    }
}
