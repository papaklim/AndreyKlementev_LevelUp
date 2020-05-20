package ru.levelup.andrey.klementev.qa.homework_4.selenium_1.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelup.andrey.klementev.qa.homework_4.selenium_1.BaseTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExerciseOneTest extends BaseTest {

    @Test
    public void executeExerciseOne() {

//        Check success login
        WebElement writeMailButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Написать письмо']")));
        assertEquals("Написать письмо", writeMailButton.getText());

//        Create new letter
        writeMailButton.click();
        WebElement to = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-type='to'] input")));
        to.sendKeys(MAIL_DESTINATION_ADDRESS);
        WebElement subject = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='Subject']")));
        subject.sendKeys(MAIL_SUBJECT_WITHOUT_TEST);
        WebElement body = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[role='textbox']")));
        body.sendKeys(MAIL_BODY_TEXT);

//        Save draft letter
        WebElement draftButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Сохранить']")));
        draftButton.click();

//        Close mail window
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='button'][title='Закрыть']")));
        closeButton.click();

//        Go to the Drafts folder
        WebElement leftNavBarDraftsButton = driver.findElement(By.xpath("//*[@class='nav__folder-name'][contains(string(), 'Черновики')]"));
        leftNavBarDraftsButton.click();
        wait.until(ExpectedConditions.titleIs("Черновики - Почта Mail.ru"));

//        Assert that draft letter in the drafts folder
        assertEquals(MAIL_BODY_TEXT, driver.findElements(By.xpath("//*[@class='llc__snippet']")).get(0).getText());

//        Open draft letter & verify destination address, mail subject & body
        WebElement draftMailBody = driver.findElement(By.xpath("//*[text()[contains(., '" + MAIL_BODY_TEXT + "')]]"));
        draftMailBody.click();
        String actualMailDestinationAddress = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[contains(@class, 'contacts')][@data-type='to']//span"))).getText();
        String ActualMailSubject = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@name='Subject']"))).getAttribute("value");
        String ActualMailBody = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[contains(@id, 'BODY')]/div/div"))).getText();
        assertAll(
                () -> assertEquals(MAIL_DESTINATION_ADDRESS, actualMailDestinationAddress),
                () -> assertEquals(MAIL_SUBJECT_WITHOUT_TEST, ActualMailSubject),
                () -> assertEquals(MAIL_BODY_TEXT, ActualMailBody));

//        Send letter from Drafts folder
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Отправить']")));
        sendButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Закрыть']"))).click();

//         Assert that letter is not in the Drafts folder
        String checkDrafts = driver.findElement(By.xpath("//*[contains(@title, 'Черновики')]")).getAttribute("title");
        if (checkDrafts.contains("нет писем")) {
            WebElement withoutDrafMails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='octopus__title']")));
            assertEquals("У вас нет незаконченных\nили неотправленных писем", withoutDrafMails.getText());
        } else {
            List<WebElement> withDrafMails = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@class='llc__snippet']"))));
            Assertions.assertNotEquals(MAIL_BODY_TEXT, withDrafMails.get(0).getText());
        }

//         Go to the Sent folder & assert that letter is in the Sent folder
        leftBarNavigate("Отправленные");
        assertEquals(MAIL_BODY_TEXT, driver.findElements(By.xpath("//*[@class='llc__snippet']")).get(0).getText());

    }

}
