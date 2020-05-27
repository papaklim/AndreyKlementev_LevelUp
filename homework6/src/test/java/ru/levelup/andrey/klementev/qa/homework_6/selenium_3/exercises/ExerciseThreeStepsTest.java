//package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.exercises;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//public class ExerciseThreeStepsTest extends BaseStepsTest {
//
//    @Test
//    public void executeExerciseThreeTest() {
//        loginPage.inputLogin(MAIL_LOGIN);
//        loginPage.selectDomain(MAIL_DOMAIN);
//        loginPage.pressSubmitButton();
//        loginPage.inputPassword(MAIL_PASSWORD);
//        loginPage.pressSubmitButton();
//        assertEquals(WRITE_MAIL, accountPage.getTextWriteMailButton(),
//                "Login failed. Couldn't find item with text: " + WRITE_MAIL);
//        accountPage.pressWriteMailButton();
//        mailPage.inputMailDestination(MAIL_SELF_ADDRESS);
//        mailPage.inputMailSubject(MAIL_SUBJECT_WITHOUT_TEST);
//        mailPage.inputMailBody(MAIL_BODY_TEXT);
//        mailPage.pressSendButton();
//        mailPage.pressCloseButton();
//        accountPage.openLeftBarNavigationFolder("Входящие");
//        assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0), ASSERT_EQL_TEXT);
//        accountPage.openMailWindowByListIndex(0);
//        assertAll(
//                () -> assertEquals(MAIL_SELF_ADDRESS, accountPage.getMailDestinationAddress()),
//                () -> assertEquals(MAIL_SUBJECT_WITHOUT_TEST, accountPage.getMailSubject()),
//                () -> assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyText())
//        );
//        accountPage.pressDeleteButton();
//        accountPage.openLeftBarNavigationFolder("Корзина");
//        assertEquals(MAIL_BODY_TEXT, accountPage.getMailBodyTextByListIndex(0), ASSERT_EQL_TEXT);
//        accountPage.userLogout();
//    }
//}