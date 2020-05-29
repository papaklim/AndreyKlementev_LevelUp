package ru.levelup.andrey.klementev.qa.homework_5.selenium_2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#mailbox [name='login']")
    @SuppressWarnings("unused")
    private WebElement loginField;

    @FindBy(css = "#mailbox [name='domain']")
    @SuppressWarnings("unused")
    private WebElement domainName;

    @FindBy(css = "#mailbox [type='submit']")
    @SuppressWarnings("unused")
    private WebElement passwordButton;

    @FindBy(css = "#mailbox [placeholder='Пароль']")
    @SuppressWarnings("unused")
    private WebElement passwordField;

    @FindBy(css = "#mailbox [type='submit']")
    @SuppressWarnings("unused")
    private WebElement submitButton;


    public void inputPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
    }

    public void pressSubmitButton() {
        submitButton.click();
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void selectDomain(String domain) {
        new Select(domainName).selectByVisibleText(domain);
    }

}
