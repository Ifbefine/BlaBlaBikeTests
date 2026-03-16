package com.blablaBike.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "email")
    WebElement emailField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(xpath = "//button[contains(text(), 'Log In')]")
    WebElement loginButton;


    public void enterEmail(String email) {
        emailField.sendKeys(email);

    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }

    public String getEmailErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));


        WebElement errorElement = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Invalid email address')]")
        ));

        return errorElement.getText();
    }

    public String getPasswordInputType() {

        return passwordField.getAttribute("type");
    }
}


