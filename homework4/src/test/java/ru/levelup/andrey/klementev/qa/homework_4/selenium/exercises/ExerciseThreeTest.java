package ru.levelup.andrey.klementev.qa.homework_4.selenium.exercises;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelup.andrey.klementev.qa.homework_4.selenium.BaseTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseThreeTest  extends BaseTest {

    @Test
    public void executeExerciseThree(){

//        Check success login
        WebElement writeMailButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Написать письмо']")));
        assertEquals("Написать письмо", writeMailButton.getText());

//        Create new letter
        writeMailButton.click();
        WebElement to = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-type='to'] input")));
        to.sendKeys(MAIL_SELF_ADDRESS);
        WebElement subject = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='Subject']")));
        subject.sendKeys(MAIL_SUBJECT_WITHOUT_TEST);
        WebElement body = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[role='textbox']")));
        body.sendKeys(MAIL_BODY_TEXT);

//        Send letter
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Отправить']")));
        sendButton.click();
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Закрыть']")));
        closeButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".layer-window__container")));

//         Go to the Inbox folder & assert that sent letter is there
        leftBarNavigate("Входящие");
        assertEquals(MAIL_BODY_TEXT, driver.findElements(By.xpath("//*[@class='llc__snippet']")).get(0).getText());

//        Open sent letter in the Inbox folder& verify destination address, mail subject & body
        WebElement draftMailBody = driver.findElement(By.xpath("//*[text()[contains(., '" + MAIL_BODY_TEXT + "')]]"));
        draftMailBody.click();
        String actualMailDestinationAddress = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='letter__author']/span"))).getAttribute("title");
        String ActualMailSubject = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='thread__header']//h2"))).getText();
        String ActualMailBody = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[contains(text(), 'TEST')]"))).getText();
        assertAll(
                () -> assertEquals(MAIL_SELF_ADDRESS, actualMailDestinationAddress),
                () -> assertEquals(MAIL_SUBJECT_WITHOUT_TEST, ActualMailSubject),
                () -> assertEquals(MAIL_BODY_TEXT, ActualMailBody)
        );

//        Delete letter from the Inbox folder
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Удалить']")));
        deleteButton.click();

//         Go to the Trash folder & assert that sent letter is there
        leftBarNavigate("Корзина");
        assertEquals(MAIL_BODY_TEXT, driver.findElements(By.xpath("//*[@class='llc__snippet']")).get(0).getText());

    }
}
