package com.blablaBike.Tests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.CatalogPage;
import com.blablaBike.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BikeListTests extends TestBase {
    private CatalogPage catalogPage;

    @BeforeEach
    public void setUp() throws IOException {
        super.setUp();

        catalogPage = new CatalogPage(driver);
        
        new HomePage(driver).openCatalog();
        catalogPage.waitForCatalogToLoad();
    }

    @Test
    @DisplayName("TS_BIKE_1.1: Проверка открытия страницы каталога")
    public void userCanOpenBikeListTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean urlChanged = wait.until(ExpectedConditions.urlContains("/catalog"));
        assertThat(urlChanged).as("URL должен содержать /catalog").isTrue();
    }

    @Test
    @DisplayName("TS_BIKE_1.2: Отображение только доступных велосипедов")
    public void onlyAvailableBikesShouldBeDisplayedTest() {
        List<String> statuses = catalogPage.getAllBikeStatuses();
        assertThat(statuses)
                .as("В каталоге должны быть только доступные велосипеды")
                .allSatisfy(status ->
                        assertThat(status.toLowerCase()).containsAnyOf("available", "free", "свободен")
                );
    }

    @Test
    @DisplayName("TS_BIKE_1.3: Отсутствие велосипедов в ремонте по умолчанию")
    public void noBikesInRepairTest() {
        assertThat(catalogPage.noBikesWithStatus("In Repair"))
                .as("В каталоге не должно быть велосипедов в ремонте").isTrue();
    }

    @Test
    @DisplayName("TS_BIKE_1.4: Отсутствие забронированных велосипедов по умолчанию")
    public void noReservedBikesTest() {
        assertThat(catalogPage.noBikesWithStatus("Reserved"))
                .as("В каталоге не должно быть забронированных велосипедов").isTrue();
    }

    @Test
    @DisplayName("TS_BIKE_1.5: Сообщение при отсутствии велосипедов после фильтрации")
    public void noBikesMessageTest() {
        catalogPage.selectStatus("In Repair");
        String message = catalogPage.getEmptyMessageText();

        assertThat(message.toLowerCase())
                .as("Должно отображаться сообщение об отсутствии результатов")
                .containsAnyOf("no", "found", "empty", "результатов", "нет");
    }

}