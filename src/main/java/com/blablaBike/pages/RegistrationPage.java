package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "a[href='/sign-up']")
    WebElement signUpButton;
    public RegistrationPage clickOnButtonSignUp() {
      click(signUpButton);
      return this;
    }


    @FindBy(xpath = "//button[normalize-space()='Google']")
    WebElement googleButton;
    public RegistrationPage clickOnButtonGoogle() {
     click(googleButton);
     return this;
    }

    @FindBy(id = "name")
    WebElement nameField;
    @FindBy(id="email")
    WebElement emailField;
    @FindBy(id = "password")
    WebElement passwordField;

    public RegistrationPage enterUserData(String name, String email, String password)
    {
     type(nameField,name);
     type(emailField,email);
     type(passwordField,password);
    return  this;
    }



    @FindBy(css = "button[type='submit']")
    WebElement submitButton;

    public RegistrationPage clickOnSubmitButtonSignUp() {
        click(submitButton);
        return this;
    }

    //@FindBy(xpath="//div[contains(text(),\"already exists\")]")
    @FindBy(xpath = "//div[contains(.,'already exists')]")
    WebElement alertAlreadyExists;

    public RegistrationPage allertDisplayExistingUser()
    {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(alertAlreadyExists));
        Assertions.assertTrue(element.getText().contains("already exists"));
     return this;
    }

    @FindBy(xpath="//div[text()=\"\"]")
    WebElement alertInvalidName;
    public RegistrationPage allertDisplayInvalidName() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(alertInvalidName));

        return this;
    }

    @FindBy(xpath = "//div[text()=\"Invalid email address\"]")
    WebElement alertInvalidEmail;

    public RegistrationPage allertDisplayInvalidEmail() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(alertInvalidEmail));
        assertTrue(alertInvalidEmail.getText().contains("Invalid email address"));
        return this;

    }


    @FindBy(css = "div.text-red-600")
    WebElement alertPassword;
    public RegistrationPage allertDisplayInvalidPassword() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(alertPassword));

        String color = element.getCssValue("color");
        String hex = Color.fromString(color).asHex();

        Assertions.assertEquals("#ef4444", hex);
        // Assertions.assertEquals("lab(55.4814 75.0732 48.8528)", color);

        return this;

    }


    public RegistrationPage allertDisplayInvalidInputField() {

        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(alertPassword));

        String color = element.getCssValue("color");
        Assertions.assertEquals("LAB(48.4493 77.4328 61.5452)", color);
        return this;
    }




    @FindBy(css = ".text-red-500, .text-red-600")
    List<WebElement> errorMessages;

    public RegistrationPage verifyAllErrorMessagesStyle() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> !errorMessages.isEmpty());

        for (WebElement error : errorMessages) {
            if (error.isDisplayed()) {
                String classes = error.getAttribute("class");

                Assertions.assertTrue(
                        classes.contains("text-red-500") || classes.contains("text-red-600"),
                        "Unexpected classes: " + classes + " for message: " + error.getText()
                );
            }
        }
        return this;
    }
}
