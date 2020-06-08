package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExerciseTwoStepsTest extends BaseStepsTest {

    @DisplayName("Scenario #2")
    @Test
    public void executeExerciseTwoTest() {
        actionSteps.loginToPage(MAIL_LOGIN, MAIL_DOMAIN, MAIL_PASSWORD);
        assertionSteps.assertSuccessLogin();
        actionSteps.pressWriteMailButton();
        actionSteps.fillMailFields(MAIL_SELF_ADDRESS, MAIL_SUBJECT_WITH_TEST, MAIL_BODY_TEXT);
        actionSteps.pressSendButton();
        actionSteps.pressCloseButton();
        actionSteps.openLeftBarNavigationFolder("Отправленные");
        assertionSteps.assertThatMailIsInTheFolder();
        actionSteps.openLeftBarNavigationFolder("Test");
        assertionSteps.assertThatMailIsInTheFolder();
        actionSteps.openFirstMailWindowInTheList();
        assertionSteps.assertFieldsWithOpenMail(MAIL_SELF_ADDRESS, MAIL_SUBJECT_WITH_TEST, MAIL_BODY_TEXT);
        actionSteps.logout();
    }
}
