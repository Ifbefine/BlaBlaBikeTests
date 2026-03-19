package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By emailField = By.cssSelector("input[type='email']");
    private final By passwordField = By.cssSelector("input[type='password']");

    private final By loginButton = By.cssSelector("button[type='submit']");

    private final By signOutButton = By.xpath("//button[contains(text(), 'Sign Out')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginAsAdmin() {
        boolean isAlreadyLoggedIn = driver.findElements(signOutButton).size() > 0;

        if (isAlreadyLoggedIn) {
            System.out.println("✅ Сессия активна, пропускаем ввод данных.");
            return;
        }

        System.out.println("🔑 Выполняю вход...");

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField))
                .sendKeys("admin@test.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField))
                .sendKeys("admin123");

        wait.until(ExpectedConditions.elementToBeClickable(loginButton))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButton));
        System.out.println("🎉 Вход выполнен успешно!");
    }
}