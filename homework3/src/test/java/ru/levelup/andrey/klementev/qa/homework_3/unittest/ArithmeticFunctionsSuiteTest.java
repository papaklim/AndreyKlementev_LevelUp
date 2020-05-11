package ru.levelup.andrey.klementev.qa.homework_3.unittest;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Test Suite: Arithmetic Functions")
@SelectPackages("ru.levelup.andrey.klementev.qa.homework_3.unittest.functions.arithmetic")
public class ArithmeticFunctionsSuiteTest {

}
