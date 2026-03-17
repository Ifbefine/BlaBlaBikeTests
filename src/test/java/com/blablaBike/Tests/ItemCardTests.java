package com.blablaBike.Tests;

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
}