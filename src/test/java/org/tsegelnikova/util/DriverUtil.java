package org.tsegelnikova.util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tsegelnikova.config.BrowsersFactory;

import java.time.Duration;

public class DriverUtil {
    public static void waitTimeout(By element, int time) {
        WebDriverWait wait = new WebDriverWait(BrowsersFactory.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public static void waitTimeoutWithPresentText(By element, int time, String gameName) {
        WebDriverWait wait = new WebDriverWait(BrowsersFactory.getDriver(), Duration.ofSeconds(time));

        wait.until(ExpectedConditions.textToBePresentInElementLocated(element, gameName));
    }
}
