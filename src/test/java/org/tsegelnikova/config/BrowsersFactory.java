package org.tsegelnikova.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.tsegelnikova.dto.Browsers;
import org.tsegelnikova.dto.Config;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

public class BrowsersFactory {
    private static WebDriver driver = getDriver();

    public static void initBrowser() {
        Config config;
        try {
            config = Config.getConfig();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        Browsers browserName = Browsers.valueOf(config.getBrowserName().toUpperCase());

        if (browserName == Browsers.CHROME) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments(config.getBrowserArguments());
            driver = new ChromeDriver(options);
        } else if (browserName == Browsers.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(config.getBrowserArguments());
            driver = new FirefoxDriver(options);
        } else {
            throw new RuntimeException("Not existing browser");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitWaitTimeout()));
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initBrowser();
        }

        return driver;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }
}
