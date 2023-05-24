package org.tsegelnikova;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.tsegelnikova.config.BrowsersFactory;
import org.tsegelnikova.dto.TestData;
import org.tsegelnikova.page.MainPage;
import org.tsegelnikova.page.PrivacyPolicyPage;
import org.tsegelnikova.util.BrowserNavigationUtil;

import java.io.IOException;
import java.net.URISyntaxException;

public class PrivacyPolicyTest {
    private TestData testData;

    @BeforeMethod
    public void setUp() throws IOException, URISyntaxException {
        testData = TestData.getTestData();
        BrowsersFactory.getDriver().get(testData.getSteamUrl());

    }

    @Test
    public void privacyPolicyTest() {
        MainPage mainPage = new MainPage();
        mainPage.scrollToPrivacy();
        mainPage.clickPrivacyPolicyButton();

        BrowserNavigationUtil.switchTab(1);

        PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();

        Assert.assertTrue(privacyPolicyPage.isSwitchLanguageDisplayed(),
                "Switch language isn't displayed");
        Assert.assertTrue(privacyPolicyPage.isLanguageIncluded(testData.getSupportLanguagesList()),
                "Languages list isn't correct");
        Assert.assertEquals(privacyPolicyPage.getDate(), testData.getPrivacyPolicyRevisionDate(),
                "The revision date isn't actual");
    }

    @AfterClass
    public static void tearDown() {
        BrowsersFactory.quit();
    }

}
