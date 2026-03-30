package com.blablaBike.Tests.AdminTests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.AddCategoryPage;
import com.blablaBike.pages.AdminDashboardPage;
import com.blablaBike.pages.CatalogPage;
import com.blablaBike.pages.LoginPage;
import com.blablaBike.pages.window.AddBikePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminAddCategoryPositiveTest extends TestBase
{
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
    public void AddCategoryPositiveTest()
    {
        new AdminDashboardPage(driver).clickOnAdminLink();
        new AddCategoryPage(driver).clickOnAddCategoryLink().EnterCategoryData("Kids bike","https://kidsbike-pro.com")
                .clickOnCreateCategoryButton()
                .verifyAddCategory();

        assertTrue(addCategoryPage.verifyAddCategory());
    }




}
