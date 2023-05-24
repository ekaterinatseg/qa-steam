package org.tsegelnikova;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.tsegelnikova.config.BrowsersFactory;
import org.tsegelnikova.dto.GameModel;
import org.tsegelnikova.dto.TestData;
import org.tsegelnikova.page.MainPage;
import org.tsegelnikova.page.SearchPage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class TestScenarioGameSearch {
    private TestData testData;

    @BeforeMethod
    public void setUp() throws IOException, URISyntaxException {
        testData = TestData.getTestData();
        BrowsersFactory.getDriver().get(testData.getSteamUrl());

    }

    @Test
    public void testScenarioGameSearch() {

        MainPage mainPage = new MainPage();

        mainPage.clickSearchField();
        mainPage.enterGameName(testData.getFirstGameSearch());

        SearchPage searchPage = new SearchPage();
        Assert.assertTrue(searchPage.isGameNameCorrect(testData.getFirstGameSearch()),
                "Game name isn't correct");
        Assert.assertTrue(searchPage.isFirstNameCorrect(testData.getFirstGameSearch()),
                "Game name isn't correct");

        List<GameModel> resultSearchList1 = new ArrayList<>();
        resultSearchList1.add(searchPage.getElementFromSearchList(1));
        resultSearchList1.add(searchPage.getElementFromSearchList(2));

        searchPage.searchGame(resultSearchList1.get(1).getName());
        Assert.assertTrue(searchPage.isGameNameCorrect(resultSearchList1.get(1).getName()),
                "Game name isn't correct");

        Assert.assertTrue(searchPage.isFirstNameCorrect(resultSearchList1.get(1).getName()),
                "Game name isn't correct");
        Assert.assertEquals(searchPage.getElementFromSearchList(2).getName(),
                testData.getFirstGameSearchSep(), "Game name isn't correct");

        List<GameModel> resultSearchList2 = new ArrayList<>();
        resultSearchList2.add(searchPage.getElementFromSearchList(1));
        resultSearchList2.add(searchPage.getElementFromSearchList(2));

        Assert.assertEquals(resultSearchList1.get(1), resultSearchList2.get(0),
                "Stored data are not matched");
    }

    @AfterClass
    public static void tearDown() {
        BrowsersFactory.quit();
    }

}
