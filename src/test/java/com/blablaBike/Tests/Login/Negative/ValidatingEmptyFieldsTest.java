package com.blablaBike.Tests.Login.Negative;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ValidatingEmptyFieldsTest extends TestBase {

    LoginPage loginPage;

    @BeforeEach
    public void setup() {
        // Драйвер уже инициализирован в TestBase, просто используем его
        loginPage = new LoginPage(driver);
        driver.get("https://blablabike-arx6.vercel.app/login");
    }

    @Test
    @Tag("Negative")
    public void testEmptyFieldsValidation() {
        loginPage.clickLoginButton();
        // Просто проверяем, что метод не упал при поиске ошибки
        loginPage.getEmailErrorMessage();
    }
}