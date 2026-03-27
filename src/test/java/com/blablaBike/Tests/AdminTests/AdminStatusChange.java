package com.blablaBike.Tests.AdminTests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.HomePage;
import com.blablaBike.pages.ItemPage;
import com.blablaBike.utils.AdminPageHelper;
import com.blablaBike.utils.CatalogHelper;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AdminStatusChange  extends TestBase {

    @Test
    public void bikeBecomesUnavailableAfterAdminChange() {

        HomePage homePage = new HomePage(driver);
        homePage.openCatalog();

        CatalogHelper helper = new CatalogHelper(driver);
        helper.openFirstAvailableItem();

        ItemPage itemPage = new ItemPage(driver);

        assertThat(itemPage.getBikeStatus()).isEqualTo("AVAILABLE");

        AdminPageHelper adminHelper = new AdminPageHelper(driver);

        adminHelper.changeBikeStatusInDB("BUSY");

        System.out.println("👉 CHANGE STATUS IN DB TO BUSY AND PRESS ENTER...");
        new java.util.Scanner(System.in).nextLine();

        driver.navigate().refresh();

        itemPage = new ItemPage(driver);

        assertThat(itemPage.getBikeStatus()).isEqualTo("BUSY");
    }

}
