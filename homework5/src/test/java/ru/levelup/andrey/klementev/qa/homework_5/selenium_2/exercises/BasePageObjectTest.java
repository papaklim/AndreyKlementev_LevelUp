package ru.levelup.andrey.klementev.qa.homework_5.selenium_2.exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelup.andrey.klementev.qa.homework_5.selenium_2.pages.AccountPage;
import ru.levelup.andrey.klementev.qa.homework_5.selenium_2.pages.LoginPage;
import ru.levelup.andrey.klementev.qa.homework_5.selenium_2.pages.MailPage;

import java.util.Date;

public abstract class BasePageObjectTest {
    public final String BASE_URL = "https://mail.ru/";
    public final String MAIL_LOGIN = "jeffrythompson1589621232102";
    public final String MAIL_DOMAIN = "@inbox.ru";
    public final String MAIL_PASSWORD = "XG3XZ1iyp";
    public final String MAIL_SELF_ADDRESS = "jeffrythompson1589621232102@inbox.ru";
    public final String MAIL_DESTINATION_ADDRESS = "mickeystamm1589731387267@inbox.ru"; //password: x784vTqV
    public final String MAIL_SUBJECT_WITHOUT_TEST = "Mail from selenium";
    public final String MAIL_SUBJECT_WITH_TEST = "Test mail from selenium";
    public final String MAIL_BODY_TEXT = "TEST: " + new Date().getTime();
    public WebDriver driver;
    public static LoginPage loginPage;
    public static AccountPage accountPage;
    public static MailPage mailPage;


    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        mailPage = new MailPage(driver);
        driver.get(BASE_URL);
    }

    @AfterEach
    public void tearDown(){
        driver.close();
    }
}
