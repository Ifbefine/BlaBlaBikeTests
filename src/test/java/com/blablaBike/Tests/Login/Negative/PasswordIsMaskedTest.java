package com.blablaBike.Tests.Login.Negative;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasswordIsMaskedTest extends TestBase {
    WebDriver driver;
    LoginPage loginPage;
    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://blablabike-arx6.vercel.app/login");
        loginPage = new LoginPage(driver);


    }
    @Test
    @Tag("OK")
    public void testPasswordIsMasked() {

        String inputType = loginPage.getPasswordInputType();
        Assertions.assertEquals("password", inputType);
        System.out.println(inputType);

}
    }
