package com.blablaBike.Tests.CatalogTests;

import com.blablaBike.core.BasePage;
import com.blablaBike.core.TestBase;
import com.blablaBike.pages.HomePage;
import com.blablaBike.pages.CatalogPage;
import com.blablaBike.pages.ItemPage;
import com.blablaBike.utils.CatalogHelper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemCardTests extends TestBase {

    @Test
    public void itemPhotoDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.isImageVisible()).isTrue();
    }

    @Test
    public void itemTypeDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.getItemType()).isNotEmpty();
    }

//    @Test
//    public void itemPriceDisplayed() {
//
//        HomePage homePage = new HomePage(driver);
//        homePage.openCatalog();
//
//        CatalogHelper helper = new CatalogHelper(driver);
//        helper.openFirstAvailableItem();
//
//        ItemPage itemPage = new ItemPage(driver);
//
//        assertThat(itemPage.getTotalPrice())
//                .contains("€");
//    }

    @Test
    public void rentalRateDisplayed() {

        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.getRentalRate())
                .contains("€");
    }

    @Test
    public void itemAvailabilityStatusDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.getAvailabilityStatus()).isNotEmpty();
    }

    @Test
    public void rentButtonDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.isRentButtonVisible()).isTrue();
    }

    @Test
    public void bikeNameDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.getBikeName()).isNotEmpty();
    }

//    @Test
//    public void placeholderWhenNoImage() {
//        HomePage homePage = new HomePage(driver);
//        homePage.openCatalog();
//
//        CatalogPage catalogPage = new CatalogPage(driver);
//        catalogPage.openItemWithPlaceholderImage();
//
//        ItemPage itemPage = new ItemPage(driver);
//
//        assertThat(itemPage.isPlaceholderDisplayed()).isTrue();
//    }

    @Test
    public void calendarIsDisplayed() {

        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.isCalendarDisplayed()).isTrue();
    }

    @Test
    public void itemCategoryDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.getCategory()).isNotEmpty();
    }

    @Test
    public void totalPriceDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.getTotalPrice())
                .contains("€");
    }

    @Test
    public void orderSummaryIsDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.isOrderSummaryDisplayed()).isTrue();
    }

    @Test
    public void bookButtonIsEnabled() {
        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.isBookButtonEnabled()).isTrue();
    }

    @Test
    public void imageZoomOpens() {
        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        itemPage.clickOnImage();

        assertThat(itemPage.isZoomModalDisplayed()).isTrue();
    }

    @Test
    public void durationDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.getDuration()).contains("Day");
    }

    @Test
    public void bikeInfoDisplayedAndValid() {
        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.isOrderSummaryDisplayed()).isTrue();

        assertThat(itemPage.getBikeName()).isNotEmpty();
        assertThat(itemPage.getCategory()).isNotEmpty();
        assertThat(itemPage.getRentalRate()).isNotEmpty();
        assertThat(itemPage.getTotalPrice()).isNotEmpty();
    }


}