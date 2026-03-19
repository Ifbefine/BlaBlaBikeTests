package com.blablaBike.pages.window;

import com.blablaBike.core.BasePage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddBikePage extends BasePage {
    public AddBikePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Brand']")
    WebElement brandInput;
    @FindBy(xpath= "//input[@placeholder='Model']")
    WebElement modelInput;
    @FindBy(xpath = "//textarea[@placeholder='Description']")
    WebElement descriptionInput;
    @FindBy(xpath = "//input[@placeholder='Price per day']")
    WebElement priceInput;

    @FindBy(xpath = "//input[@placeholder='Price per day']")
    WebElement imageInput;


    public AddBikePage enterDataBike(String brand, String model, String description, String price, String url) {
        type(brandInput, brand);
        type(modelInput, model);
        type(descriptionInput, description);
        type(priceInput, price);
        type(imageInput, url);
        return this;

    }
    @FindBy(css = "select[name='bike_category_id']")
    WebElement bikeCategory;
    @FindBy(xpath = "/html/body/div[2]/main/main/div/div[3]/form/select/option[9]")
    WebElement cyclocrossCategory;

    public AddBikePage selectBikeCategory() {

    click(bikeCategory);
    click(cyclocrossCategory);
        return this;
    }
    @FindBy(css = "button[type='submit']")
    WebElement saveButton;

    public AddBikePage clickOnSaveButton() {
        click(saveButton);
        return this;
    }

@FindBy(xpath = "//a[normalize-space()='Catalog']")
WebElement catalogButton;
    public AddBikePage clickOnCatalogButton() {
        click(catalogButton);
        return this;
    }
}
