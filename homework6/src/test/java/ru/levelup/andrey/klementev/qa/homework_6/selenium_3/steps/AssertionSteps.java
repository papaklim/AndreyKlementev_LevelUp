package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionSteps extends BaseSteps{

    public AssertionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Assert that login was success")
    public void assertSuccessLogin(){
        assertEquals(WRITE_MAIL, accountPage.getTextWriteMailButton(),
                "Login failed. Couldn't find item with text: " + WRITE_MAIL);
    }
}
