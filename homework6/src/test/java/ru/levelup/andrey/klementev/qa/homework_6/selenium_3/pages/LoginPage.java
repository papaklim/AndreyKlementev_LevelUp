package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.pages;

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
    private WebElement loginField;

    @FindBy(css = "#mailbox [name='domain']")
    private WebElement domainName;

    @FindBy(css = "#mailbox [placeholder='Пароль']")
    private WebElement passwordField;

    @FindBy(css = "#mailbox [type='submit']")
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
