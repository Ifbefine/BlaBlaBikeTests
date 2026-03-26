package com.blablaBike.pages.window;

import com.blablaBike.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddAccessoriesPage extends BasePage {
    public AddAccessoriesPage(WebDriver driver) {
        super(driver);
    }

@FindBy(xpath = "//input[@placeholder='Name']")
WebElement nameField;

    @FindBy(xpath = "//input[@placeholder='Price per day']")
    WebElement pricePerDayField;
    public AddAccessoriesPage enterAccessoryData(String acccessoryName, String acccessoryPrice) {
type(nameField,acccessoryName);
type(pricePerDayField,acccessoryPrice);

        return this;
    }

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    public AddAccessoriesPage clickOnAccessorySaveButton() {
        click(saveButton);
        return this;
    }


    public AddAccessoriesPage verifyInvalidPriceAlert() {

        Boolean rangeUnderflow = (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].validity.rangeUnderflow;", pricePerDayField);

        assertTrue(rangeUnderflow);

        return this;
    }


    public  AddAccessoriesPage verifyAllertInDisplay() {


        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(nameField));

        String color = element.getCssValue("color");
        Assertions.assertEquals("rgba(0, 0, 0, 1)", color);



        return this;
    }
}
