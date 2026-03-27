package com.blablaBike.Tests.Login.Negative;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailSensetivityTest extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(EmailSensetivityTest.class);
    WebDriver driver;
    LoginPage loginPage;
    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://blablabike-arx6.vercel.app/login");
        loginPage = new LoginPage(driver);


    }
    @Test
    @Tag("Ok")
    public void emailSensetivityTest(){
        loginPage.enterEmail("TesT123456789@GM.COM");
        loginPage.enterPassword("Test123456789@");
        loginPage.clickLoginButton();
    }
    @Test
    @Tag("OK")
    public void emailSensetivityTestWithSpacesTest(){
        loginPage.enterEmail(" test123456789@gm.com ");
        loginPage.enterPassword("Test123456789@");
        loginPage.clickLoginButton();
    }
    @Test
    @Tag("OK")
    public void entryWithoutEmailTest(){
        loginPage.enterEmail("");
        loginPage.enterPassword("Test123456789@");
        loginPage.clickLoginButton();
    }
}
