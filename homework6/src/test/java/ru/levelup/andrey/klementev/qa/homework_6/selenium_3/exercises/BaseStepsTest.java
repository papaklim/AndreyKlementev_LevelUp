package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelup.andrey.klementev.qa.homework_6.selenium_3.steps.ActionSteps;
import ru.levelup.andrey.klementev.qa.homework_6.selenium_3.steps.AssertionSteps;

import java.util.Date;


public abstract class BaseStepsTest {

    public static final String BASE_URL = "https://mail.ru/";
    public static final String MAIL_LOGIN = "jeffrythompson1589621232102";
    public static final String MAIL_DOMAIN = "@inbox.ru";
    public static final String MAIL_PASSWORD = "XG3XZ1iyp";
    public static final String MAIL_SELF_ADDRESS = "jeffrythompson1589621232102@inbox.ru";
    public static final String MAIL_DESTINATION_ADDRESS = "mickeystamm1589731387267@inbox.ru"; //password: x784vTqV
    public static final String MAIL_SUBJECT_WITHOUT_TEST = "Mail from selenium";
    public static final String MAIL_SUBJECT_WITH_TEST = "Test mail from selenium";
    public static final String MAIL_BODY_TEXT = "TEST: " + new Date().getTime();

    protected WebDriver driver;
    protected ActionSteps actionSteps;
    protected AssertionSteps assertionSteps;


    @Step("Go to the page: " + BASE_URL)
    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(BASE_URL);
        actionSteps = new ActionSteps(driver);
        assertionSteps = new AssertionSteps(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
