package org.tsegelnikova.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Config {
    private String browserArguments;
    private String browserName;
    private int implicitWaitTimeout;

    public Config() {
    }

    public Config(String browserArguments, String browserName, int implicitWaitTimeout) {
        this.browserArguments = browserArguments;
        this.browserName = browserName;
        this.implicitWaitTimeout = implicitWaitTimeout;
    }

    public static Config getConfig() throws IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        URL resource = Config.class.getClassLoader().getResource("Config.json");
        File file = new File(resource.toURI());
        return mapper.readValue(file, Config.class);
    }

    public String getBrowserArguments() {
        return browserArguments;
    }

    public void setBrowserArguments(String browserArguments) {
        this.browserArguments = browserArguments;
    }

    public int getImplicitWaitTimeout() {
        return implicitWaitTimeout;
    }

    public void setImplicitWaitTimeout(int implicitWaitTimeout) {
        this.implicitWaitTimeout = implicitWaitTimeout;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }
}

