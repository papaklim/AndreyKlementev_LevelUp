package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.steps;

import org.openqa.selenium.WebDriver;
import ru.levelup.andrey.klementev.qa.homework_6.selenium_3.pages.AccountPage;
import ru.levelup.andrey.klementev.qa.homework_6.selenium_3.pages.LoginPage;
import ru.levelup.andrey.klementev.qa.homework_6.selenium_3.pages.MailPage;

import java.util.Date;

public class BaseSteps {

    protected static final String WRITE_MAIL = "Написать письмо";
    protected static final String MAIL_LOGIN = "jeffrythompson1589621232102";
    protected static final String MAIL_DOMAIN = "@inbox.ru";
    protected static final String MAIL_PASSWORD = "XG3XZ1iyp";
    protected static final String MAIL_SELF_ADDRESS = "jeffrythompson1589621232102@inbox.ru";
    protected static final String MAIL_DESTINATION_ADDRESS = "mickeystamm1589731387267@inbox.ru"; //password: x784vTqV
    protected static final String MAIL_SUBJECT_WITHOUT_TEST = "Mail from selenium";
    protected static final String MAIL_SUBJECT_WITH_TEST = "Test mail from selenium";
    protected static final String MAIL_BODY_TEXT = "TEST: " + new Date().getTime();
    protected static final String ASSERT_EQL_TEXT = "Verifying that mail is in the current folder failed: mail's body " +
            "text doesn't match with mail's body text from first mail in the list";
    protected static final String ASSERT_NOT_EQL_TEXT = "Verifying that mail isn't in the current folder failed: mail's" +
            " body text match with mail's body text from first mail in the list";

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected MailPage mailPage;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        mailPage = new MailPage(driver);
    }
}
