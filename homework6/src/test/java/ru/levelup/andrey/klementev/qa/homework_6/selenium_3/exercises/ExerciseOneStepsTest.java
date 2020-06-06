package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.exercises;

import org.junit.jupiter.api.Test;

public class ExerciseOneStepsTest extends BaseStepsTest {


    @Test
    public void executeExerciseOne() {
        actionSteps.loginToPage(MAIL_LOGIN, MAIL_DOMAIN, MAIL_PASSWORD);
        assertionSteps.assertSuccessLogin();
        actionSteps.pressWriteMailButton();
        actionSteps.fillMailFields(MAIL_DESTINATION_ADDRESS, MAIL_SUBJECT_WITHOUT_TEST, MAIL_BODY_TEXT);
        actionSteps.pressSaveButton();
        actionSteps.pressCloseButton();
        actionSteps.openLeftBarNavigationFolder("Черновики");
        assertionSteps.assertThatMailIsInTheFolder();
        assertionSteps.assertFieldsWithoutOpenMail(MAIL_DESTINATION_ADDRESS, MAIL_SUBJECT_WITHOUT_TEST, MAIL_BODY_TEXT);
        actionSteps.openFirstMailWindowInTheList();
        actionSteps.pressSendButton();
        actionSteps.pressCloseButton();
        assertionSteps.assertThatMailIsNotInTheFolder();
        actionSteps.openLeftBarNavigationFolder("Отправленные");
        assertionSteps.assertThatMailIsInTheFolder();
        actionSteps.logout();
    }
}
