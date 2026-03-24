package com.blablaBike.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class CatalogHelper {

    private WebDriver driver;

    public CatalogHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openFirstAvailableItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> items = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//a[contains(@href,'/catalog/')][.//*[contains(text(),'Available')]]")
                )
        );

        items.get(0).click();
    }
}