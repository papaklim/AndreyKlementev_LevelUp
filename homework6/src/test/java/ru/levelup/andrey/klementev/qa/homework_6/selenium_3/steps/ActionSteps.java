package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static ru.levelup.andrey.klementev.qa.homework_6.selenium_3.exercises.BaseStepsTest.BASE_URL;

public class ActionSteps extends BaseSteps {


    public ActionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Login to the page: https://mail.ru/")
    public void loginToPage() {
        loginPage.inputLogin(MAIL_LOGIN);
        loginPage.selectDomain(MAIL_DOMAIN);
        loginPage.pressSubmitButton();
        loginPage.inputPassword(MAIL_PASSWORD);
        loginPage.pressSubmitButton();
    }

    @Step("Press the button: \"Написать письмо\"")
    public void pressWriteMailButton() {
        accountPage.pressWriteMailButton();
    }

    @Step("Fill the mail fields: Address,Subject, Body")
    public void fillMailFields() {
        mailPage.inputMailDestination(MAIL_DESTINATION_ADDRESS);
        mailPage.inputMailSubject(MAIL_SUBJECT_WITHOUT_TEST);
        mailPage.inputMailBody(MAIL_BODY_TEXT);
    }

    @Step("Press the button: \"Save\"")
    public void pressSaveButton() {
        mailPage.pressSaveButton();
    }
}
