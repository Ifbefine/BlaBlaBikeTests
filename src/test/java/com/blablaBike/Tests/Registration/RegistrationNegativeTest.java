package com.blablaBike.Tests.Registration;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.HomePage;
import com.blablaBike.pages.RegistrationPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationNegativeTest extends TestBase {
HomePage homePage;
RegistrationPage registrationPage;
    @BeforeEach
    public void preconditions() {
     homePage = new HomePage(driver);
     assertTrue(homePage.isBannerVisible());
     registrationPage= new RegistrationPage(driver);

    }

    @Test
    public void registrationNegativeExistingEmailNameTest()
    {
      new RegistrationPage(driver).clickOnButtonSignUp().enterUserData("Mariia Testova","maritest1@gmail.com","Test1234$")
              .clickOnSubmitButtonSignUp()
              .allertDisplayExistingUser();

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/InvalidName.csv", numLinesToSkip = 1)
    public void registrationNegativeWithInvalidName(String name,String email,String password)
    {
       new RegistrationPage(driver).clickOnButtonSignUp().enterUserData(name,email,password).clickOnSubmitButtonSignUp().allertDisplayInvalidName();

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/InvalidEmail.csv",numLinesToSkip = 1)
    public void registrationNegativeWithInvalidEmail(String name,String email,String password)
    {
        new RegistrationPage(driver).clickOnButtonSignUp()
                .enterUserData(name,email,password)
                .clickOnSubmitButtonSignUp()
                .allertDisplayInvalidEmail();
    }




    @ParameterizedTest
    @CsvFileSource(resources = "/InvalidPassword.csv",numLinesToSkip = 1)
    public void registrstionNegativeWithInvalidPassword(String name,String email,String password)
    {
        new RegistrationPage(driver).clickOnButtonSignUp()
                .enterUserData(name,email,password)
                .clickOnSubmitButtonSignUp()
               .allertDisplayInvalidPassword()
        ;

    }





}
