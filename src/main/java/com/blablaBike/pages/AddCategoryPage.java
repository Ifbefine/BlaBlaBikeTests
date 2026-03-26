package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import com.blablaBike.pages.window.AddBikePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCategoryPage extends BasePage {

    public AddCategoryPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[normalize-space()='Categories']")
    WebElement addCategoryButton;

    public AddCategoryPage clickOnAddCategoryLink() {

        click(addCategoryButton);

        return this;
    }

    @FindBy(xpath = "//input[@placeholder='Category name']")
    WebElement categoryNameField;
    @FindBy(xpath = "//input[@placeholder='https://example.com/category.jpg']")
    WebElement categoryUrlField;

    public AddCategoryPage EnterCategoryData(String categoryName, String categoryUrl) {
        type(categoryNameField, categoryName);
        type(categoryUrlField, categoryUrl);

        return this;
    }

    @FindBy(xpath = "//button[normalize-space()='Create Category']")
    WebElement createCategoryButton;
    public AddCategoryPage clickOnCreateCategoryButton() {
        pause(500);
        click(createCategoryButton);

        return this;
    }

    public boolean verifyAddCategory() {

        By categoryLocator = By.xpath("//*[text()='Kids bike']");;

        // первая попытка поиска
        for (int i = 0; i < 5; i++) {
            if (!driver.findElements(categoryLocator ).isEmpty()) {
                WebElement category = driver.findElement(categoryLocator );
                js.executeScript("arguments[0].scrollIntoView({block:'center'});", category);
                return category.isDisplayed();
            }

            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            pause(500);
        }

        return false;
    }

    public AddCategoryPage enterParametrCategoryData(String categoryName, String categoryUrl) {

        type(categoryNameField, categoryName);
        type(categoryUrlField, categoryUrl);

        return this;
    }


    public AddCategoryPage verifyAllertInDisplay() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(categoryNameField));
        WebElement element2 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(categoryUrlField));


        String color = element.getCssValue("color");
        Assertions.assertEquals("rgba(0, 0, 0, 1)", color);



        return this;
    }
}
