package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExerciseThreeStepsTest extends BaseStepsTest {

    @DisplayName("Scenario #3")
    @Test
    public void executeExerciseThreeTest() {
        actionSteps.loginToPage(MAIL_LOGIN, MAIL_DOMAIN, MAIL_PASSWORD);
        assertionSteps.assertSuccessLogin();
        actionSteps.pressWriteMailButton();
        actionSteps.fillMailFields(MAIL_SELF_ADDRESS, MAIL_SUBJECT_WITHOUT_TEST, MAIL_BODY_TEXT);
        actionSteps.pressSendButton();
        actionSteps.pressCloseButton();
        actionSteps.openLeftBarNavigationFolder("Входящие");
        assertionSteps.assertThatMailIsInTheFolder();
        actionSteps.openFirstMailWindowInTheList();
        assertionSteps.assertFieldsWithOpenMail(MAIL_SELF_ADDRESS, MAIL_SUBJECT_WITHOUT_TEST, MAIL_BODY_TEXT);
        actionSteps.pressDeleteButton();
        actionSteps.openLeftBarNavigationFolder("Корзина");
        assertionSteps.assertThatMailIsInTheFolder();
        actionSteps.logout();
    }
}