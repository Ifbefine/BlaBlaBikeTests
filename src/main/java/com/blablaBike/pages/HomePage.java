package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public Object getAlerts;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    private WebElement mainBanner;


    public boolean isBannerVisible() {
        waitOfElementVisibility(mainBanner,10);
        return isElementVisible(mainBanner);
    }

    public String getBannerText() {
        waitOfElementVisibility(mainBanner,10);
        return mainBanner.getText();
    }


    @FindBy(xpath = "//a[@href='/catalog' and contains(text(), 'Rent Now')]")
    private WebElement rentNowButton;
    public void clickRentNow() {
        waitOfElementVisibility(rentNowButton, 10);
        rentNowButton.click();
    }
}
