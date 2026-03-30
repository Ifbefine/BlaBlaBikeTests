package com.blablaBike.Tests.AdminTests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.AddCategoryPage;
import com.blablaBike.pages.AdminDashboardPage;
import com.blablaBike.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AdminAddCategoryNegativeTest extends TestBase {

    AdminDashboardPage adminDashboardPage;
    LoginPage loginPage;
    AddCategoryPage addCategoryPage;

    @BeforeEach
    public void precondition() {
        driver.get("https://blablabike.vercel.app/login");

        loginPage = new LoginPage(driver);
        loginPage.enterEmail("mariadmin@gmail.com");
        loginPage.enterPassword("Test1234$");
        loginPage.clickLoginButton();
        adminDashboardPage = new AdminDashboardPage(driver);
        adminDashboardPage.verifyPageAdminDashboard();
        addCategoryPage = new AddCategoryPage(driver);


    }


    @Test
    public void addCategoryNegativeWithExistCategoryTest()
    {
        new AdminDashboardPage(driver).clickOnAdminLink();
        new AddCategoryPage(driver).clickOnAddCategoryLink().EnterCategoryData("Kids bike","https://kidsbike-pro.com")
                .clickOnCreateCategoryButton()
                .verifyAllertInDisplay()
        ;

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/InvalidDataCategory.csv", numLinesToSkip = 1)
    public void addCategoryNegativeWithInvalidCategoryTest(String categoryName, String categoryUrl)
    {
        new AdminDashboardPage(driver).clickOnAdminLink();
        new AddCategoryPage(driver).clickOnAddCategoryLink()
                .enterParametrCategoryData(categoryName,categoryUrl)
                .clickOnCreateCategoryButton()
                .verifyAllertInDisplay()
        ;

    }







}
