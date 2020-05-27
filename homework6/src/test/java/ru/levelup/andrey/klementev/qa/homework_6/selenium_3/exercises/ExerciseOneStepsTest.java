package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.exercises;

import org.junit.jupiter.api.Test;

public class ExerciseOneStepsTest extends BaseStepsTest {


    @Test
    public void executeExerciseOne() {
        actionSteps.loginToPage();
        assertionSteps.assertSuccessLogin();
        actionSteps.pressWriteMailButton();
        actionSteps.fillMailFields();
        actionSteps.pressSaveButton();
//        mailPage.pressCloseButton();
//        accountPage.openLeftBarNavigationFolder("Черновики");
//        assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0), ASSERT_EQL_TEXT);
//        assertAll(
//                () -> assertEquals(MAIL_DESTINATION_ADDRESS, accountPage.getMailDestinationAddressByListIndex(0)),
//                () -> assertEquals(MAIL_SUBJECT_WITHOUT_TEST, accountPage.getMailSubjectByListIndex(0)),
//                () -> assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0))
//        );
//        accountPage.openMailWindowByListIndex(0);
//        mailPage.pressSendButton();
//        mailPage.pressCloseButton();
//        assertNotEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0), ASSERT_NOT_EQL_TEXT);
//        accountPage.openLeftBarNavigationFolder("Отправленные");
//        assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0), ASSERT_EQL_TEXT);
//        accountPage.userLogout();
    }
}
