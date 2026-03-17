package com.blablaBike.Tests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FirstTestForCheck extends TestBase {
    @Test
    @DisplayName("Проверка наличия главного баннера на странице")
    public void bannerShouldBeVisibleTest() {
        HomePage homePage = new HomePage(driver);

        assertThat(homePage.isBannerVisible())
                .as("Главный баннер должен быть отображен")
                .isTrue();


        assertThat(homePage.getBannerText())
                .as("Текст баннера отображется")
//                .contains("BlablaBike");
                .contains("Savor");
    }

    @Test
    @DisplayName("74BB-4: Проверка перехода в каталог через кнопку Rent Now")
    public void userCanOpenCatalogTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickRentNow();

        String currentUrl = driver.getCurrentUrl();

        assertThat(currentUrl)
                .as("После нажатия на Rent Now должен открыться каталог")
                .contains("catalog");
    }

}

