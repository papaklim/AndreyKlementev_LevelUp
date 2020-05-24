package ru.levelup.andrey.klementev.qa.homework_5.selenium_2.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExerciseThreePageObjectTest extends BasePageObjectTest {

    @Test
    public void executeExerciseThreeTest() {
        loginPage.inputLogin(MAIL_LOGIN);
        loginPage.selectDomain(MAIL_DOMAIN);
        loginPage.pressSubmitButton();
        loginPage.inputPassword(MAIL_PASSWORD);
        loginPage.pressSubmitButton();
        Assertions.assertEquals("Написать письмо", accountPage.getTextWriteMailButton(),
                "Login failed. Couldn't find item with text: \"Написать письмо\"");
        accountPage.pressWriteMailButton();
        mailPage.inputMailDestination(MAIL_SELF_ADDRESS);
        mailPage.inputMailSubject(MAIL_SUBJECT_WITHOUT_TEST);
        mailPage.inputMailBody(MAIL_BODY_TEXT);
        mailPage.pressSendButton();
        mailPage.pressCloseButton();
        accountPage.openLeftBarNavigationFolder("Входящие");
        Assertions.assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0),
                "Verifying that mail is in the current folder failed: mail's body text doesn't match with " +
                        "mail's body text from first mail in the list");
        accountPage.openMailWindowByListIndex(0);
        Assertions.assertAll(
                () -> Assertions.assertEquals(MAIL_SELF_ADDRESS, accountPage.getMailDestinationAddress()),
                () -> Assertions.assertEquals(MAIL_SUBJECT_WITHOUT_TEST, accountPage.getMailSubject()),
                () -> Assertions.assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyText())
        );
        accountPage.pressDeleteButton();
        accountPage.openLeftBarNavigationFolder("Корзина");
        Assertions.assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0),
                "Verifying that mail is in the current folder failed: mail's body text doesn't match with " +
                        "mail's body text from first mail in the list");
        accountPage.userLogout();
    }
}