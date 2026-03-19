package com.blablaBike.Tests.CatalogTests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.HomePage;
import com.blablaBike.pages.CatalogPage;
import com.blablaBike.pages.ItemPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemCardTests extends TestBase {

    @Test
    public void itemPhotoDisplayed() {

        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openSecondItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.isImageVisible()).isTrue();
    }

    @Test
    public void itemTypeDisplayed() {

        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openSecondItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.getItemType()).isNotEmpty();
    }

    @Test
    public void itemPriceDisplayed() {

        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openSecondItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.getItemPrice())
                .contains("₽");
    }

    @Test
    public void itemAvailabilityStatusDisplayed() {

        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openSecondItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.getAvailabilityStatus())
                .isNotEmpty();
    }

    @Test
    public void rentButtonDisplayed() {

        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openSecondItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.isRentButtonVisible()).isTrue();
    }

    @Test
    public void bikeNameDisplayed() {

        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openSecondItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.getBikeName())
                .isNotEmpty();
    }

    @Test
    public void placeholderWhenNoImage() {

        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openItemWithPlaceholderImage();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.isPlaceholderDisplayed()).isTrue();
    }


}