package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccessoriesPage extends BasePage {
    public AccessoriesPage(WebDriver driver) {
        super(driver);



    }

    @FindBy(xpath = "//button[normalize-space()='Add Accessory']")
    WebElement addAccessoriesButton;
    public AccessoriesPage clickOnAddAccessoryButton() {
    click(addAccessoriesButton);
        return this;
    }


    public boolean verifyAddAccessory() {

        By accessoriesLocator = By.xpath("//*[text()='Schlemtest']");;

        // первая попытка поиска
        for (int i = 0; i < 5; i++) {
            if (!driver.findElements(accessoriesLocator ).isEmpty()) {
                WebElement accessories = driver.findElement(accessoriesLocator );
                js.executeScript("arguments[0].scrollIntoView({block:'center'});", accessories);
                return accessories.isDisplayed();
            }

            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            pause(500);
        }


        return false;
    }
}
