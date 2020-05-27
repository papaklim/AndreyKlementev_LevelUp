package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailPage extends BasePage {

    public MailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-type='to'] input")
    @SuppressWarnings("unused")
    private WebElement mailDestinationAddressField;

    @FindBy(css = "input[name='Subject']")
    @SuppressWarnings("unused")
    private WebElement mailSubject;

    @FindBy(css = "[role='textbox']")
    @SuppressWarnings("unused")
    private WebElement mailBody;

    @FindBy(css = "[title='Закрыть']")
    @SuppressWarnings("unused")
    private WebElement closeButton;

    @FindBy(css = "[title='Отправить']")
    @SuppressWarnings("unused")
    private WebElement sendButton;

    @FindBy(css = "[title='Сохранить']")
    @SuppressWarnings("unused")
    private WebElement saveButton;

    public void inputMailDestination(String address){
        wait.until(ExpectedConditions.visibilityOf(mailDestinationAddressField));
        mailDestinationAddressField.sendKeys(address);
    }

    public void inputMailSubject(String subject){
        mailSubject.sendKeys(subject);
    }

    public void inputMailBody(String body){
        mailBody.sendKeys(body);
    }

    public void pressCloseButton(){
        wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        closeButton.click();
    }

    public void pressSendButton(){
        wait.until(ExpectedConditions.elementToBeClickable(sendButton));
        sendButton.click();
    }

    public void pressSaveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

}
