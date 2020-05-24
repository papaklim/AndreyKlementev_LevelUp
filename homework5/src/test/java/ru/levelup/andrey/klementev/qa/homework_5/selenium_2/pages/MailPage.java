package ru.levelup.andrey.klementev.qa.homework_5.selenium_2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailPage extends BasePage{

    public MailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-type='to'] input")
    private WebElement mailDestinationAddressField;

    @FindBy(css = "input[name='Subject']")
    private WebElement mailSubject;

    @FindBy(css = "[role='textbox']")
    private WebElement mailBody;

    @FindBy(css = "[title='Закрыть']")
    private WebElement closeButton;

    @FindBy(css = "[title='Отправить']")
    private WebElement sendButton;

    @FindBy(css = "[title='Сохранить']")
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
