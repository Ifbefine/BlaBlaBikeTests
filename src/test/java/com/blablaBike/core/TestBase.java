package com.blablaBike.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestBase {
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeEach
    public void setUp() throws IOException {
        Properties props = new Properties();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) {
                throw new RuntimeException("Файл config.properties не найден!");
            }
            props.load(is);
        }

        // ключ именно "baseUrl" (регистр важен!)
        this.baseUrl = props.getProperty("baseUrl");
        if (baseUrl == null || baseUrl.isEmpty()) {
            baseUrl = "http://localhost:3000";
        }

        WebDriver originalDriver = new ChromeDriver();
        MyListener listener = new MyListener();
        this.driver = new EventFiringDecorator<>(listener).decorate(originalDriver);

        this.driver.manage().window().maximize();


        System.out.println("Перехожу по адресу: " + baseUrl); //
        this.driver.get(baseUrl);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
