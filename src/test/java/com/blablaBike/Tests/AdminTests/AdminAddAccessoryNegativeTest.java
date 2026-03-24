package com.blablaBike.Tests.AdminTests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.AccessoriesPage;
import com.blablaBike.pages.AdminDashboardPage;
import com.blablaBike.pages.CatalogPage;
import com.blablaBike.pages.LoginPage;
import com.blablaBike.pages.window.AddAccessoriesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AdminAddAccessoryNegativeTest extends TestBase {

    AdminDashboardPage adminDashboardPage;
    CatalogPage catalogPage;
    LoginPage loginPage;
    AccessoriesPage accessoriesPage;
    AddAccessoriesPage addAccessoriesPage;

    @BeforeEach
    public void precondition() {
        driver.get("https://blablabike-arx6.vercel.app/login");
        loginPage = new LoginPage(driver);
        loginPage.enterEmail("mariadmin@gmail.com");
        loginPage.enterPassword("Test1234$");
        loginPage.clickLoginButton();
        adminDashboardPage = new AdminDashboardPage(driver);
        adminDashboardPage.verifyPageAdminDashboard();
        catalogPage = new CatalogPage(driver);
        accessoriesPage = new AccessoriesPage(driver);
        addAccessoriesPage = new AddAccessoriesPage(driver);

    }


    @Test
    public void addAccessoriesNegativWithExistAccessoryTest()
    {
        new AdminDashboardPage(driver).clickOnAdminLink().clickOnAccessoriesLink();
        new AccessoriesPage(driver).clickOnAddAccessoryButton();
        new AddAccessoriesPage(driver).enterAccessoryData("Helmet","4")
                .clickOnAccessorySaveButton()
                // .verifyAllertInDisplay()
        ;

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/InvalidAccessoriesData.csv", numLinesToSkip = 1)
    public void addAccessoriesNegativeWithInvalidDataTest(String accessoriesName, String accessoryPrice)
    {

        new AdminDashboardPage(driver).clickOnAdminLink().clickOnAccessoriesLink();
        new AccessoriesPage(driver).clickOnAddAccessoryButton();
        new AddAccessoriesPage(driver).enterAccessoryData(accessoriesName,accessoryPrice).clickOnAccessorySaveButton();
        new AccessoriesPage(driver).verifyAddAccessory()
        //        .verifyAllertInDislay()
        ;

    }


    @Test
    public void addAccessoriesWithNegativePriceTest()
    {
        new AdminDashboardPage(driver).clickOnAdminLink().clickOnAccessoriesLink();
        new AccessoriesPage(driver).clickOnAddAccessoryButton();
        new AddAccessoriesPage(driver).enterAccessoryData("HelmetTest","-10")
                .clickOnAccessorySaveButton()
                .verifyInvalidPriceAlert();

    }

}
