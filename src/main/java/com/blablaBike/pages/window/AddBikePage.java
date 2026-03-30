package com.blablaBike.pages.window;

import com.blablaBike.core.BasePage;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @FindBy(xpath = "//input[@placeholder='Image URL']")
    WebElement imageInput;


    public AddBikePage enterDataBike(String brand, String model, String description, String price) {
        type(brandInput, brand);
        type(modelInput, model);
        type(descriptionInput, description);
        type(priceInput, price);

        return this;

    }



    @FindBy(css = "select[name='bike_category_id']")
    WebElement bikeCategory;
    @FindBy(xpath = "//option[@value='6a04b768-965c-43f1-8bb3-47487711c7d9']")
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

    public AddBikePage verifyMesageAddBike() {

        WebElement descriptionField = driver.findElement(By.name("model"));

        String validationMessage = descriptionField.getAttribute("validationMessage");

        System.out.println(validationMessage);

        //assertEquals(validationMessage, "Заполните это поле.");
        assertEquals("Заполните это поле.",validationMessage);
        return this;
    }

    public AddBikePage verifyValidationMessagesForEmptyRequiredFields(String brand, String model, String price) {
        if (brand == null || brand.isBlank()) {
            Assertions.assertFalse(
                    brandInput.getAttribute("validationMessage").isEmpty(),
                    "Brand field should show validation message"
            );
        }

        if (model == null || model.isBlank()) {
            Assertions.assertFalse(
                    modelInput.getAttribute("validationMessage").isEmpty(),
                    "Model field should show validation message"
            );
        }

        if (price == null || price.isBlank()) {
            Assertions.assertFalse(
                    priceInput.getAttribute("validationMessage").isEmpty(),
                    "Price field should show validation message"
            );
        }

        return this;
    }


    public AddBikePage enterInvalidDataAddBike(String brand, String model,String price) {

       type(brandInput, brand);
       type(modelInput, model);
       type(priceInput, price);
        return this;
    }




}
