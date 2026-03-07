package com.blablaBike.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeEach
    public void setUp() throws IOException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        props.load(fis);
        baseUrl = props.getProperty("baseUrl"); // это наш сайт на основе localhost:3000


        WebDriver originalDriver = new ChromeDriver();
        MyListener listener = new MyListener();
        this.driver = new EventFiringDecorator<>(listener).decorate(originalDriver);

        this.driver.manage().window().maximize();

        // 3. Используем считанный URL
        this.driver.get(baseUrl);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
