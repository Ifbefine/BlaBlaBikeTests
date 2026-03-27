package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Log In')]")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void loginAsAdmin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();

        // Ждем, пока мы попадем хоть куда-то (в админку или профиль пользователя)
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("admin"),
                ExpectedConditions.urlContains("user-profile")
        ));
    }

    public String getEmailErrorMessage() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorElement = shortWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Invalid email address')]")
        ));
        return errorElement.getText();
    }

    public String getPasswordInputType() {
        return passwordField.getAttribute("type");
    }
}