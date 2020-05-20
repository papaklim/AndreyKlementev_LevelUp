package ru.levelup.andrey.klementev.qa.homework_4.selenium_1;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Test Suite: All Calculator Functions")
@SelectPackages({"ru.levelup.andrey.klementev.qa.homework_4.selenium.exercises"})

public class ExercisesSuite {

}
