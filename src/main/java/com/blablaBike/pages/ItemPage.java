package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "img")
    private WebElement itemImage;

    public boolean isImageVisible() {
        return itemImage.isDisplayed();
    }

    @FindBy(css = ".bg-blue-600")
    private WebElement itemType;

    public String getItemType() {
        return itemType.getText();
    }

    @FindBy(css = "p.text-3x1")
    private WebElement itemPrice;

    public String getItemPrice() {

    }


}
