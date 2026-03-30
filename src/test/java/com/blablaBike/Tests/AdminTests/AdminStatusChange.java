package com.blablaBike.Tests.AdminTests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.HomePage;
import com.blablaBike.pages.ItemPage;
import com.blablaBike.utils.AdminPageHelper;
import com.blablaBike.utils.CatalogHelper;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AdminStatusChange extends TestBase {

//    @Test
//    public void bikeBecomesUnavailableAfterAdminChange() throws InterruptedException {
//
//        HomePage homePage = new HomePage(driver);
//        homePage.openCatalog();
//
//        CatalogHelper helper = new CatalogHelper(driver);
//        helper.openFirstAvailableItem();
//
//        ItemPage itemPage = new ItemPage(driver);
//
//        assertThat(itemPage.getBikeStatus()).isEqualToIgnoringCase("available");
//
//        AdminPageHelper adminHelper = new AdminPageHelper(driver);
//        adminHelper.changeBikeStatusInDB("BUSY");
//
//        boolean isUpdated = false;
//
//        for (int i = 0; i < 15; i++) {
//
//            homePage.openCatalog();
//
//            helper.openFirstAvailableItem();
//
//            itemPage = new ItemPage(driver);
//
//            if (itemPage.getBikeStatus().equalsIgnoreCase("busy")) {
//                isUpdated = true;
//                break;
//            }
//
//            Thread.sleep(2000);
//        }
//
//        assertThat(isUpdated).isTrue();
//    }

    @Test
    public void allItemsShouldHaveValidStatus() {

        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        List<WebElement> items = driver.findElements(By.cssSelector("a[href*='/catalog/']"));
        int count = items.size();

        for (int i = 0; i < count; i++) {

            items = driver.findElements(By.cssSelector("a[href*='/catalog/']"));
            items.get(i).click();

            ItemPage itemPage = new ItemPage(driver);

            String status = itemPage.getBikeStatus();

            assertThat(status).isNotEmpty();
            assertThat(status.toLowerCase()).isIn("available", "busy");

            driver.navigate().back();
        }
    }
    @Test
    public void statusPersistsAfterRefresh() {

        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        String initialStatus = itemPage.getBikeStatus();

        driver.get(driver.getCurrentUrl());

        itemPage = new ItemPage(driver);

        String statusAfterRefresh = itemPage.getBikeStatus();

        assertThat(statusAfterRefresh).isEqualToIgnoringCase(initialStatus);
    }
}

