package org.tsegelnikova.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class TestData {
    private String firstGameSearch;
    private String firstGameSearchSep;
    private String steamUrl;
    private String privacyPolicyRevisionDate;
    private String uniqueElementSteamSearch;
    private String uniqueElementPrivacyPolicy;
    private List<String> supportLanguagesList;


    public TestData() {
    }

    public TestData(String firstGameSearch, String steamUrl,
                    String privacyPolicyRevisionDate, String uniqueElementSteamSearch,
                    String uniqueElementPrivacyPolicy,
                    List<String> supportLanguagesList) {
        this.firstGameSearch = firstGameSearch;
        this.firstGameSearchSep = firstGameSearchSep;
        this.steamUrl = steamUrl;
        this.privacyPolicyRevisionDate = privacyPolicyRevisionDate;
        this.uniqueElementSteamSearch = uniqueElementSteamSearch;
        this.uniqueElementPrivacyPolicy = uniqueElementPrivacyPolicy;
        this.supportLanguagesList = supportLanguagesList;
    }

    public String getFirstGameSearch() {
        return firstGameSearch;
    }

    public void setFirstGameSearch(String firstGameSearch) {
        this.firstGameSearch = firstGameSearch;
    }

    public String getFirstGameSearchSep() {
        return firstGameSearchSep;
    }

    public void setFirstGameSearchSep(String firstGameSearchSep) {
        this.firstGameSearchSep = firstGameSearchSep;
    }

    public String getSteamUrl() {
        return steamUrl;
    }

    public void setSteamUrl(String steamUrl) {
        this.steamUrl = steamUrl;
    }


    public String getPrivacyPolicyRevisionDate() {
        return privacyPolicyRevisionDate;
    }

    public void setPrivacyPolicyRevisionDate(String privacyPolicyRevisionDate) {
        this.privacyPolicyRevisionDate = privacyPolicyRevisionDate;
    }
    public String getUniqueElementPrivacyPolicy() {
        return uniqueElementPrivacyPolicy;
    }

    public void setUniqueElementPrivacyPolicy(String uniqueElementPrivacyPolicy) {
        this.uniqueElementPrivacyPolicy = uniqueElementPrivacyPolicy;
    }
    public String getUniqueElementSteamSearch() {
        return uniqueElementSteamSearch;
    }

    public void setUniqueElementSteamSearch(String uniqueElementSteamSearch) {
        this.uniqueElementSteamSearch = uniqueElementSteamSearch;
    }

    public List<String> getSupportLanguagesList() {
        return supportLanguagesList;
    }

    public void setSupportLanguagesList(List<String> supportLanguagesList) {
        this.supportLanguagesList = supportLanguagesList;
    }

    public static TestData getTestData() throws IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        URL resource = TestData.class.getClassLoader().getResource("TestData.json");
        File file = new File(resource.toURI());
        return mapper.readValue(file, TestData.class);
    }
}

