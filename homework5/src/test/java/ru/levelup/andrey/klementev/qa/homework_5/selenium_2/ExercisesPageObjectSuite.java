package ru.levelup.andrey.klementev.qa.homework_5.selenium_2;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Test Suite: Execute All Exercises")
@SelectPackages({"ru.levelup.andrey.klementev.qa.homework_5.selenium_2.exercises"})

public class ExercisesPageObjectSuite {

}
