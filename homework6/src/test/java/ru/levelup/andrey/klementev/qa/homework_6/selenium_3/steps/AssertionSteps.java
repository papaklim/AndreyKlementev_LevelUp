package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;
import static ru.levelup.andrey.klementev.qa.homework_6.selenium_3.exercises.BaseStepsTest.*;

public class AssertionSteps extends BaseSteps {

    public AssertionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Assert that login was success")
    public void assertSuccessLogin() {
        assertEquals(WRITE_MAIL, accountPage.getTextWriteMailButton(),
                "Login failed. Couldn't find item with text: " + WRITE_MAIL);
    }

    @Step("Assert that mail is in the folder: compare entered mail body text with mail body text by first mail in the list")
    public void assertThatMailIsInTheFolder() {
        assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0), ASSERT_EQL_TEXT);
    }


    @Step("Assert that: entered mail fields address, subject, body compare with fields by first mail in the list")
    public void assertFieldsWithoutOpenMail(String address, String subject, String body) {
        assertAll(
                () -> assertEquals(address, accountPage.getMailDestinationAddressByListIndex(0)),
                () -> assertEquals(subject, accountPage.getMailSubjectByListIndex(0)),
                () -> assertEquals(body, accountPage.getMailBodyTextByListIndex(0))
        );
    }
    @Step("Assert that: entered mail fields address, subject, body compare with fields by first mail in the list")
    public void assertFieldsWithOpenMail(String address, String subject, String body) {
        assertAll(
                () -> assertEquals(address, accountPage.getMailDestinationAddress()),
                () -> assertEquals(subject, accountPage.getMailSubject()),
                () -> assertEquals(body, accountPage.getMailBodyText())
        );
    }
    @Step("Assert that mail is not in the folder: compare entered mail body text with mail body text by first mail in the list")
    public void assertThatMailIsNotInTheFolder() {
        assertNotEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0), ASSERT_NOT_EQL_TEXT);

    }
}
