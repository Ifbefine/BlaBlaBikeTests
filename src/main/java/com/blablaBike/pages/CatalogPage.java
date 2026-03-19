package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage extends BasePage {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[contains(@class,'bg-gray-100')]")
    WebElement showSelect;

    @FindBy(xpath = "//option[@value='3']")
    WebElement showSelect12;
    @FindBy(xpath = "//*[contains(text(),'TEST')]")
    WebElement addedBikeBrand;



    public CatalogPage waitForCatalogPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("catalog"));
        return this;
    }

    public boolean isBikeAdded() {
        scrollWithJS(0, 1000);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(addedBikeBrand));
        return addedBikeBrand.isDisplayed();
    }
    public CatalogPage verifyAddBike()
    {
        scrollWithJS(0,3000);
        clickWithJS(showSelect);
        clickWithJS(showSelect12);

        return this;
    }
}
