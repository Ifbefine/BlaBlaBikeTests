package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
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
}
