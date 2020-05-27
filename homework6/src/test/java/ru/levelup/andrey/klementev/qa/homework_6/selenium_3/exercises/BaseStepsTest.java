package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelup.andrey.klementev.qa.homework_6.selenium_3.steps.ActionSteps;
import ru.levelup.andrey.klementev.qa.homework_6.selenium_3.steps.AssertionSteps;


public abstract class BaseStepsTest {

    protected static final String BASE_URL = "https://mail.ru/";

    protected WebDriver driver;
    protected ActionSteps actionSteps;
    protected AssertionSteps assertionSteps;


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
