package org.tsegelnikova.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.tsegelnikova.config.BrowsersFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class PrivacyPolicyPage {
    private final WebElement languageLine = BrowsersFactory.getDriver()
            .findElement(By.xpath("//*[@id='languages']"));
    private final List<WebElement> realLanguages = BrowsersFactory.getDriver()
            .findElements(By.xpath("//*[@id='languages']//a"));
    private final WebElement dateText = BrowsersFactory.getDriver()
            .findElement(By.xpath("//*[@id='newsColumn']//i[3]"));


    public boolean isNewTabOpened(String uniqueElementName) {
        return BrowsersFactory.getDriver().
                findElement(By.xpath("//*[@id='ssa_box']/a")).getText().equals(uniqueElementName);
    }

    public boolean isSwitchLanguageDisplayed() {
        return languageLine.isDisplayed();
    }

    public boolean isLanguageIncluded(List<String> languages) {
        return languages.containsAll(realLanguages.stream()
                .map(el -> el.getAttribute("href"))
                .map(el ->
                        Arrays.stream(el.split("/"))
                                .reduce((first, second) -> second)
                                .orElse("")
                )
                .collect(Collectors.toList()));
    }

    public String getDate() {
        return dateText.getText();
    }
}
