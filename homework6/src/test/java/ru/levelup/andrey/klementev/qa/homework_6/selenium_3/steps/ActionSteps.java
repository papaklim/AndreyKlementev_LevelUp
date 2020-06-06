package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionSteps extends BaseSteps {


    public ActionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Log in to the mail account")
    public void loginToPage(String mailLogin, String mailDomain, String mailPassword) {
        loginPage.inputLogin(mailLogin);
        loginPage.selectDomain(mailDomain);
        loginPage.pressSubmitButton();
        loginPage.inputPassword(mailPassword);
        loginPage.pressSubmitButton();
    }

    @Step("Press the button: \"Написать письмо\"")
    public void pressWriteMailButton() {
        accountPage.pressWriteMailButton();
    }

    @Step("Fill the mail fields: address, subject, body")
    public void fillMailFields(String address, String subject, String body) {
        mailPage.inputMailDestination(address);
        mailPage.inputMailSubject(subject);
        mailPage.inputMailBody(body);
    }

    @Step("Press the button: \"Save\"")
    public void pressSaveButton() {
        mailPage.pressSaveButton();
    }

    @Step("Press the button: \"Close\"")
    public void pressCloseButton() {
        mailPage.pressCloseButton();
    }

    @Step("Press the button: \"Send\"")
    public void pressSendButton() {
        mailPage.pressSendButton();
    }

    @Step("Press the button: \"Delete\"")
    public void pressDeleteButton() {
        accountPage.pressDeleteButton();
    }

    @Step("Open left bar navigation menu")
    public void openLeftBarNavigationFolder(String name) {
        accountPage.openLeftBarNavigationFolder(name);
    }

    @Step("Open first mail in the list")
    public void openFirstMailWindowInTheList() {
        accountPage.openMailWindowByListIndex(0);
    }

    @Step("Log out from the mail account")
    public void logout() {
        accountPage.userLogout();
    }


}
