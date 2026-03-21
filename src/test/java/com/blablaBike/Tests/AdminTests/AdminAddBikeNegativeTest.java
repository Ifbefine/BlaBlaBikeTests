package com.blablaBike.Tests.AdminTests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.AdminDashboardPage;
import com.blablaBike.pages.CatalogPage;
import com.blablaBike.pages.LoginPage;
import com.blablaBike.pages.window.AddBikePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AdminAddBikeNegativeTest extends TestBase {

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
    public void addBikeNegativeWithEmptyFieldTest()
    {
        new AdminDashboardPage(driver).clickOnAdminLink()
                .clickOnAddBikeButton();
        new AddBikePage(driver).enterDataBike("TEST3","","Bike for Urban ","220","https://surl.li/jtxuxr")
                .selectBikeCategory()
                .clickOnSaveButton()
                .verifyMesageAddBike()
        ;


    }


   @ParameterizedTest
   @CsvFileSource(resources = "/NegativeDataAddBike.csv", numLinesToSkip = 1)
    public void AdminAddBikeNegativeWithInvalidDataFields(String brand,String model,String price) {

        new AdminDashboardPage(driver).clickOnAdminLink()
                .clickOnAddBikeButton();
        new AddBikePage(driver).enterInvalidDataAddBike(brand,model,price).selectBikeCategory().clickOnSaveButton().verifyMesageAddBike();

    }




}
