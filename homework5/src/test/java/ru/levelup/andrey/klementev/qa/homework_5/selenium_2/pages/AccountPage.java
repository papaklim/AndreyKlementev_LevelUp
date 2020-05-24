package ru.levelup.andrey.klementev.qa.homework_5.selenium_2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[title='Написать письмо']")
    private WebElement writeMailButton;

    @FindBy(xpath = "//*[@class='llc__snippet']")
    private List<WebElement> mailBodiesList;

    @FindBy(css = ".letter__body [class*=class] div")
    private WebElement mailBodyText;

    @FindBy(xpath = "//*[@class='ll-crpt']")
    private List<WebElement> mailDestinationAddresseesList;

    @FindBy(xpath = "//*[@class='letter-contact']")
    private WebElement mailDestinationAddress;

    @FindBy(xpath = "//*[@class='ll-sj__normal']")
    private List<WebElement> mailSubjectsList;

    @FindBy(css = ".thread__subject-line h2")
    private WebElement mailSubject;

    @FindBy(xpath = "//*[@data-title-shortcut='Del']")
    private WebElement deleteButton;

    @FindBy(id = "PH_logoutLink")
    private WebElement logoutLink;

    public void pressWriteMailButton() {
        wait.until(ExpectedConditions.elementToBeClickable(writeMailButton));
        writeMailButton.click();
    }

    public String getTextWriteMailButton() {
        wait.until(ExpectedConditions.elementToBeClickable(writeMailButton));
        return writeMailButton.getText();
    }

    public void openLeftBarNavigationFolder(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(@class, 'nav__folder-name__txt') and contains(text(), '" + name + "')]"))).click();
        wait.until(ExpectedConditions.titleContains(name));
    }

    public String getMailBodyTextByListIndex(int index) {
        return mailBodiesList.get(index).getText();
    }

    public String getMailBodyText() {
        wait.until(ExpectedConditions.visibilityOf(mailBodyText));
        return mailBodyText.getText();
    }

    public String getMailDestinationAddressByListIndex(int index) {
        return mailDestinationAddresseesList.get(index).getAttribute("title");
    }

    public String getMailDestinationAddress() {
        wait.until(ExpectedConditions.visibilityOf(mailDestinationAddress));
        return mailDestinationAddress.getAttribute("title");
    }

    public String getMailSubjectByListIndex(int index) {
        return mailSubjectsList.get(index).getText();
    }

    public String getMailSubject() {
        wait.until(ExpectedConditions.visibilityOf(mailSubject));
        return mailSubject.getText();
    }

    public void openMailWindowByListIndex(int index) {
        mailSubjectsList.get(index).click();
    }

    public void pressDeleteButton(){
        deleteButton.click();
    }

    public void userLogout() {
        logoutLink.click();
    }
}
