package ru.levelup.andrey.klementev.qa.homework_5.selenium_2.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ExerciseOnePageObjectTest extends BasePageObjectTest {

    @Test
    public void executeExerciseOne() {
        loginPage.inputLogin(MAIL_LOGIN);
        loginPage.selectDomain(MAIL_DOMAIN);
        loginPage.pressSubmitButton();
        loginPage.inputPassword(MAIL_PASSWORD);
        loginPage.pressSubmitButton();
        assertEquals(WRITE_MAIL, accountPage.getTextWriteMailButton(),
                "Login failed. Couldn't find item with text: " + WRITE_MAIL);
        accountPage.pressWriteMailButton();
        mailPage.inputMailDestination(MAIL_DESTINATION_ADDRESS);
        mailPage.inputMailSubject(MAIL_SUBJECT_WITHOUT_TEST);
        mailPage.inputMailBody(MAIL_BODY_TEXT);
        mailPage.pressSaveButton();
        mailPage.pressCloseButton();
        accountPage.openLeftBarNavigationFolder("Черновики");
        assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0), ASSERT_EQL_TEXT);
        assertAll(
                () -> assertEquals(MAIL_DESTINATION_ADDRESS, accountPage.getMailDestinationAddressByListIndex(0)),
                () -> assertEquals(MAIL_SUBJECT_WITHOUT_TEST, accountPage.getMailSubjectByListIndex(0)),
                () -> assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0))
        );
        accountPage.openMailWindowByListIndex(0);
        mailPage.pressSendButton();
        mailPage.pressCloseButton();
        assertNotEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0), ASSERT_NOT_EQL_TEXT);
        accountPage.openLeftBarNavigationFolder("Отправленные");
        assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0), ASSERT_EQL_TEXT);
        accountPage.userLogout();
    }
}
