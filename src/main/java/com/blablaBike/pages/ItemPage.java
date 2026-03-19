package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "div.relative img")
    private WebElement itemImage;

    public boolean isImageVisible() {
        return itemImage.isDisplayed();
    }


    @FindBy(css = "div.bg-blue-600")
    private WebElement itemType;

    public String getItemType() {
        return itemType.getText();
    }


    @FindBy(css = "p.text-4xl.font-black")
    private WebElement itemPrice;


    public String getItemPrice() {
        return itemPrice.getText();
    }

    @FindBy(css = "div[class*='bg-']")
    private WebElement availabilityStatus;

    public String getAvailabilityStatus() {
        return availabilityStatus.getText();
    }

    @FindBy(css = "button.w-full")
    private WebElement rentButton;

    public boolean isRentButtonVisible() {
        return rentButton.isDisplayed();
    }

    @FindBy(css = "h1")
    private WebElement bikeName;

    public String getBikeName() {
        return bikeName.getText();
    }

    @FindBy(xpath = "//img[contains(@src,'placeholder-bike')]")
    private WebElement placeholderImage;

    public boolean isPlaceholderDisplayed() {
        return isElementVisible(placeholderImage);
    }


}