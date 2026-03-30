package com.blablaBike.Tests.Login.Positive;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LoginTests extends TestBase {
    //WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    public void setup() {
//        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://blablabike.vercel.app/login");
        loginPage = new LoginPage(driver);


    }

    @Test
    @Tag("OK")
    public void loginSuccessfulTest() {
        loginPage.enterEmail("test123456789@gm.com");
        loginPage.enterPassword("Test123456789@");
        loginPage.clickLoginButton();
    }
}
