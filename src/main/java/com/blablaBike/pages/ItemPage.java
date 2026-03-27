package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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


    @FindBy(xpath = "//span[normalize-space()='Rental rate']/following-sibling::span")
    private WebElement rentalRate;

    public String getRentalRate() {
        wait.until(ExpectedConditions.visibilityOf(rentalRate));
        return rentalRate.getText();
    }

    @FindBy(xpath = "//div[contains(@class,'border-t')]//span[contains(@class,'text-4xl')]")
    private WebElement totalPrice;

    public String getTotalPrice() {
        wait.until(ExpectedConditions.visibilityOf(totalPrice));
        return totalPrice.getText();
    }

    @FindBy(css = "div[class*='bg-']")
    private WebElement availabilityStatus;

    public String getAvailabilityStatus() {
        wait.until(ExpectedConditions.visibilityOf(status));
        return status.getText();
    }

    @FindBy(xpath = "//button[contains(text(),'Confirm & Book Now')]")
    private WebElement rentButton;

    public boolean isRentButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(rentButton));
        return rentButton.isDisplayed();
    }

    @FindBy(xpath = "//h2[text()='Order Summary']/following::h1[1]")
    private WebElement bikeBrand;

    @FindBy(xpath = "//h2[text()='Order Summary']/following::h3[1]")
    private WebElement bikeModel;

    public String getBikeName() {
        wait.until(ExpectedConditions.visibilityOf(bikeBrand));
        return bikeBrand.getText() + " " + bikeModel.getText();
    }

    @FindBy(xpath = "//img[contains(@src,'placeholder-bike')]")
    private WebElement placeholderImage;

    public boolean isPlaceholderDisplayed() {
        return isElementVisible(placeholderImage);
    }

    @FindBy(xpath = "//div[text()='Busy']")
    private WebElement busyLabel;


    public boolean isBusyDisplayed() {
        return isElementVisible(busyLabel);
    }

    @FindBy(xpath = "//h2[text()='Order Summary']")
    private WebElement orderSummary;

    @FindBy(xpath = "//div[contains(@class,'rounded-full') and (contains(text(),'Available') or contains(text(),'Busy'))]")
    private WebElement status;

    @FindBy(xpath = "//button[contains(text(),'Confirm & Book Now')]")
    private WebElement bookButton;

    public boolean isBookButtonEnabled() {
        wait.until(ExpectedConditions.visibilityOf(bookButton));
        return bookButton.isEnabled();
    }

    @FindBy(xpath = "//h5[contains(text(),'202')]")
    private WebElement calendar;

    public boolean isCalendarDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(calendar));
        return calendar.isDisplayed();
    }

    public boolean isBookButtonDisplayed() {
        return isElementVisible(bookButton);
    }

    @FindBy(xpath = "//span[text()='Category']/following-sibling::span")
    private WebElement category;

    public String getCategory() {
        wait.until(ExpectedConditions.visibilityOf(category));
        return category.getText();
    }

    public boolean isOrderSummaryDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(orderSummary));
        return orderSummary.isDisplayed();
    }

    public String getStatus() {
        return status.getText();
    }

    @FindBy(xpath = "//div[contains(@class,'cursor-zoom-in')]")
    private WebElement bikeImage;

    public void clickOnImage() {
        wait.until(ExpectedConditions.elementToBeClickable(bikeImage));
        bikeImage.click();
    }

    @FindBy(xpath = "//div[contains(@class,'fixed') and contains(@class,'backdrop-blur')]")
    private WebElement zoomModal;

    public boolean isZoomModalDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(zoomModal));
        return zoomModal.isDisplayed();
    }

    @FindBy(xpath = "//span[contains(text(),'Duration')]/following-sibling::span")
    private WebElement duration;

    public String getDuration() {
        wait.until(ExpectedConditions.visibilityOf(duration));
        return duration.getText();
    }

}