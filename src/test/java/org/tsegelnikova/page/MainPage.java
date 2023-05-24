package org.tsegelnikova.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.tsegelnikova.config.BrowsersFactory;
import org.tsegelnikova.util.DriverUtil;

public class MainPage {
    private final By policyButtonPath = By.xpath("//*[@id='footer_text']//a[1]");
    private final WebElement privacyPolicyButton = BrowsersFactory.getDriver()
            .findElement(policyButtonPath);
    private final WebElement mainPageSearchField = BrowsersFactory.getDriver()
            .findElement(By.xpath("//*[@id='store_nav_search_term']"));

    public void scrollToPrivacy() {
        Actions scrollToPrivacy = new Actions(BrowsersFactory.getDriver());
        scrollToPrivacy.scrollToElement(privacyPolicyButton).perform();
        //for firefox
        // scrollToPrivacy.scrollByAmount(0, 400).perform();
    }

    public void clickPrivacyPolicyButton() {
        DriverUtil.waitTimeout(policyButtonPath, 30);

        privacyPolicyButton.click();
    }


    public void clickSearchField() {
        mainPageSearchField.click();
    }

    public void enterGameName(String gameName) {
        mainPageSearchField.sendKeys(gameName, Keys.ENTER);
    }
}
