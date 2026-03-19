package com.blablaBike.Tests.AdminTests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.AdminDashboardPage;
import com.blablaBike.pages.CatalogPage;
import com.blablaBike.pages.window.AddBikePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminAddBikePositiveTest extends TestBase {

    AdminDashboardPage adminDashboardPage;
    AddBikePage addBikePage;
    CatalogPage catalogPage;

    @BeforeEach
    public void precondition() {
        driver.get("https://blablabike-arx6.vercel.app/admin");
        adminDashboardPage = new AdminDashboardPage(driver);
        adminDashboardPage.verifyPageAdminDashboard();
        addBikePage = new AddBikePage(driver);
        catalogPage = new CatalogPage(driver);

    }

    @Test
    public void addBikePositiveTest()
    {
//        new AdminDashboardPage(driver).clickOnAddBikeButton();
//        new AddBikePage(driver).enterDataBike("TEST","Cross Classico 3","Bike for Urban ","104","https://surl.li/jtxuxr")
//                .selectBikeCategory()
//                .clickOnSaveButton();
        new AddBikePage(driver) .clickOnCatalogButton();
        new CatalogPage(driver).waitForCatalogPage();
        assertTrue(catalogPage.isBikeAdded());




    }



}
