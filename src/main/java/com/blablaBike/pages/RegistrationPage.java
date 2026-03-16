package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


}
