package ru.levelup.andrey.klementev.qa.homework_6.selenium_3.listener;

import java.util.Optional;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.TakesScreenshot;
import ru.levelup.andrey.klementev.qa.homework_6.selenium_3.exercises.BaseStepsTest;

import static org.openqa.selenium.OutputType.*;


public class AllureTestListener implements TestWatcher {

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable) {
        System.out.println("Test aborted");
    }

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {
        System.out.println("TEST DISABLED!!!");
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        takeScreenshot();
        System.out.println("TEST FAILED!!!");
    }


    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        // do something
    }

    public static void takeScreenshot() {
        byte[] array;
        TakesScreenshot takesScreenshot = (TakesScreenshot) BaseStepsTest.driver;
        array = takesScreenshot.getScreenshotAs(BYTES);
        System.out.println("Taking screenshot...");
        Allure.getLifecycle().addAttachment("screenshot_failure", "image/png", ".png", array);
    }
    
}
