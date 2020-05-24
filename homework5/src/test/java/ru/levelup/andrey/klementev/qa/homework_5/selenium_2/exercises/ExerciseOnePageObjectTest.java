package ru.levelup.andrey.klementev.qa.homework_5.selenium_2.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ExerciseOnePageObjectTest extends BasePageObjectTest {

    @Test
    public void executeExerciseOne() {
        loginPage.inputLogin(MAIL_LOGIN);
        loginPage.selectDomain(MAIL_DOMAIN);
        loginPage.pressSubmitButton();
        loginPage.inputPassword(MAIL_PASSWORD);
        loginPage.pressSubmitButton();
        Assertions.assertEquals("Написать письмо", accountPage.getTextWriteMailButton(),
                "Login failed. Couldn't find item with text: \"Написать письмо\"");
        accountPage.pressWriteMailButton();
        mailPage.inputMailDestination(MAIL_DESTINATION_ADDRESS);
        mailPage.inputMailSubject(MAIL_SUBJECT_WITHOUT_TEST);
        mailPage.inputMailBody(MAIL_BODY_TEXT);
        mailPage.pressSaveButton();
        mailPage.pressCloseButton();
        accountPage.openLeftBarNavigationFolder("Черновики");
        Assertions.assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0),
                "Verifying that mail is in the current folder failed: mail's body text doesn't match with " +
                        "mail's body text from first mail in the list");
        Assertions.assertAll(
                () -> Assertions.assertEquals(MAIL_DESTINATION_ADDRESS, accountPage.getMailDestinationAddressByListIndex(0)),
                () -> Assertions.assertEquals(MAIL_SUBJECT_WITHOUT_TEST, accountPage.getMailSubjectByListIndex(0)),
                () -> Assertions.assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0))
        );
        accountPage.openMailWindowByListIndex(0);
        mailPage.pressSendButton();
        mailPage.pressCloseButton();
        Assertions.assertNotEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0),
                "Verifying that mail isn't in the current folder failed: mail's body text match with mail's " +
                        "body text from first mail in the list");
        accountPage.openLeftBarNavigationFolder("Отправленные");
        Assertions.assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0),
                "Verifying that mail is in the current folder failed: mail's body text doesn't match with " +
                        "mail's body text from first mail in the list");
        accountPage.userLogout();
    }
}
