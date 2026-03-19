package com.blablaBike.Tests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.HomePage;
import com.blablaBike.pages.ProfilePage;
import com.blablaBike.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationPositiveTest extends TestBase {
HomePage homePage;
ProfilePage profilePage;
    @BeforeEach
    public void preconditions() {
      homePage=new HomePage(driver);
      assertTrue(homePage.isBannerVisible());
      profilePage= new ProfilePage(driver);

    }

    @Test
    public void testRegistrationWithGoogle()
    {
       new RegistrationPage(driver).clickOnButtonSignUp().clickOnButtonGoogle();

    }


    @Test
    public void testRegistrationWithEmail()
    {
        //String email = "mariia" + System.currentTimeMillis() + "@gmail.com";
        new RegistrationPage(driver).clickOnButtonSignUp().enterUserData("Mariia Testova","maritest3@gmail.com","Test123$")
                .clickOnSubmitButtonSignUp();
        new ProfilePage(driver).verifyUserName("Mariia Testova");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ValidRegistrData.csv", numLinesToSkip = 1)
    public void testRegistrationWithParameters(String name, String email, String password)
    {
        new RegistrationPage(driver).clickOnButtonSignUp().enterUserData(name,email,password)
                .clickOnSubmitButtonSignUp();
        new ProfilePage(driver).verifyUserName(name);

    }














}
