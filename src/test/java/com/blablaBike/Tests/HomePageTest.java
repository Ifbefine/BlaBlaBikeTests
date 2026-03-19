package com.blablaBike.Tests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends TestBase {


    @Test
    public void openHomePage() {

        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isBannerVisible());

    }

}
