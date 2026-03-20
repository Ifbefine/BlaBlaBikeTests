package com.blablaBike.Tests.AdminTests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.AdminDashboardPage;
import com.blablaBike.pages.CatalogPage;
import com.blablaBike.pages.LoginPage;
import com.blablaBike.pages.window.AddBikePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminAddBikePositiveTest extends TestBase {

    AdminDashboardPage adminDashboardPage;
    AddBikePage addBikePage;
    CatalogPage catalogPage;
    LoginPage loginPage;

    @BeforeEach
    public void precondition() {
        driver.get("https://blablabike-arx6.vercel.app/login");

        loginPage = new LoginPage(driver);
        loginPage.enterEmail("mariadmin@gmail.com");
        loginPage.enterPassword("Test1234$");
        loginPage.clickLoginButton();
        adminDashboardPage = new AdminDashboardPage(driver);
        adminDashboardPage.verifyPageAdminDashboard();
        addBikePage = new AddBikePage(driver);
        catalogPage = new CatalogPage(driver);



    }


    @Test
    public void addBikePositiveTest()
    {

//        new AdminDashboardPage(driver).clickOnAdminLink()
//                .clickOnAddBikeButton()
//        ;
//        new AddBikePage(driver).enterDataBike("TEST","Cross Classico 3","Bike for Urban ","104","https://surl.li/jtxuxr")
//                .selectBikeCategory()
//                .clickOnSaveButton()
//        ;
        new AddBikePage(driver) .clickOnCatalogButton();
        new CatalogPage(driver).waitForCatalogPage();
        assertTrue(catalogPage.isBikeAdded());




    }



}
