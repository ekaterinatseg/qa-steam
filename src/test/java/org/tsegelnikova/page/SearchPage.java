package org.tsegelnikova.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.tsegelnikova.config.BrowsersFactory;
import org.tsegelnikova.dto.GameModel;
import org.tsegelnikova.util.DriverUtil;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage {
    private final WebElement searchBox = BrowsersFactory.getDriver()
            .findElement(By.xpath("//div[@class='searchbar_left']//input[@id='term']"));


    public boolean isGameNameCorrect(String gameName) {
        return searchBox.getAttribute("value").equals(gameName);
    }


    public boolean isFirstNameCorrect(String gameName) {
        DriverUtil.waitTimeoutWithPresentText(By.xpath("//*[@id='search_resultsRows']//a[1]//div[2]//div[1]"),
                30, gameName);

        return getElementFromSearchList(1).getName().equals(gameName);
    }

    public void searchGame(String gameName) {
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(gameName, Keys.ENTER);

        DriverUtil.waitTimeout(By.xpath("//*[@id='search_resultsRows']//a[1]//div[2]"), 300);
    }


   
    public GameModel getElementFromSearchList(int gameNumber) {
        String pathToGameObject = "//*/a[" + gameNumber + "]//div[2]//";
        WebElement game1 = BrowsersFactory.getDriver().findElement(By.xpath("//*[@id='search_resultsRows']//a[" + gameNumber + "]"));

        String name = game1.findElement(By.xpath(pathToGameObject + "div[1]")).getText();
        String realiseDate = game1.findElement(By.xpath(pathToGameObject + "div[2]")).getText();
        String price = game1.findElement(By.xpath(pathToGameObject + "div[4]")).getText();
        String review = game1.findElement(By.xpath(pathToGameObject + "div[3]//span")).getAttribute("className");
        List<String> platforms = game1.findElements(By.xpath(pathToGameObject + "div[1]//div//*"))
                .stream()
                .map(el -> el.getAttribute("className"))
                .collect(Collectors.toList());

        return new GameModel(name, platforms, realiseDate, review, price);
    }
}
