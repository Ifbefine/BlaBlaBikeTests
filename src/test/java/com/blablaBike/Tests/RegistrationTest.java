package com.blablaBike.Tests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.HomePage;
import com.blablaBike.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest extends TestBase {
HomePage homePage;
    @BeforeEach
    public void preconditions() {
      homePage=new HomePage(driver);
      assertTrue(homePage.isBannerVisible());
    }

    @Test
    public void testRegistrationWithGoogle()
    {
       new RegistrationPage(driver).clickOnButtonSignUp().clickOnButtonGoogle();

    }

    @Test
    public void testRegistrationWithEmail()
    {
        new RegistrationPage(driver).clickOnButtonSignUp().enterUserData("Mariia Testova","maritest@gmail.com","Test123$").clickOnSubmitButtonSignUp();
    }









}
