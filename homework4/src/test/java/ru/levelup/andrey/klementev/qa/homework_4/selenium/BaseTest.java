package ru.levelup.andrey.klementev.qa.homework_4.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;


public abstract class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    public final String BASE_URL = "https://mail.ru/";
    public final String MAIL_LOGIN = "jeffrythompson1589621232102";
    public final String MAIL_PASSWORD = "XG3XZ1iyp";
    public final String MAIL_SELF_ADDRESS = "jeffrythompson1589621232102@inbox.ru";
    public final String MAIL_DESTINATION_ADDRESS = "mickeystamm1589731387267@inbox.ru"; //password: x784vTqV
    public final String MAIL_SUBJECT_WITHOUT_TEST = "Mail from selenium";
    public final String MAIL_SUBJECT_WITH_TEST = "Test mail from selenium";
    public final String MAIL_BODY_TEXT = "TEST: " + new Date().getTime();


    public void login(String login, String password) {
        driver.get(BASE_URL);
        WebElement loginField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mailbox [name='login']")));
        loginField.sendKeys(login);
        Select domainName = new Select(driver.findElement(By.cssSelector("#mailbox [name='domain']")));
        domainName.selectByVisibleText("@inbox.ru");
        WebElement inputPassword = driver.findElement(By.cssSelector("#mailbox [type='submit']"));
        inputPassword.click();
        WebElement passwordField = driver.findElement(By.cssSelector("#mailbox [placeholder='Пароль']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.cssSelector("#mailbox [type='submit']"));
        submitButton.click();
    }

    public void logout() {
        driver.findElement(By.id("PH_logoutLink")).click();
    }

    public void leftBarNavigate(String name) {
        WebElement leftBarNavigationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'nav__folder-name__txt') and contains(text(), '" + name + "')]")));
        leftBarNavigationButton.click();
        wait.until(ExpectedConditions.titleContains(name));
    }

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        login(MAIL_LOGIN, MAIL_PASSWORD);
    }

    @AfterEach
    public void tearDown() {
        logout();
        driver.close();
    }
}