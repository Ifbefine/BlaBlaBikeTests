package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminDashboardPage extends BasePage {

    public AdminDashboardPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".text-3xl.font-bold")
    WebElement elementAdminDashboard;

    public AdminDashboardPage verifyPageAdminDashboard()
    {
        waitOfElementVisibility(elementAdminDashboard,10);
        if (!isElementVisible(elementAdminDashboard)) {
            throw new AssertionError("Admin Dashboard is not visible");
        }
        return this;
    }


    @FindBy(xpath = "//button[normalize-space()='Add Bike']")
    WebElement addBikeButton;

    public AdminDashboardPage clickOnAddBikeButton() {

        click(addBikeButton);

        return this;
    }

@FindBy(xpath = "//a[normalize-space()='Admin']")
WebElement adminDashboardLink;

    public AdminDashboardPage clickOnAdminLink() {
        click(adminDashboardLink);
        return this;
    }

    @FindBy(xpath = "//a[normalize-space()='Accessories']")
    WebElement accessoriesLink;
    public AdminDashboardPage clickOnAccessoriesLink() {

        click(accessoriesLink);
        return this;

    }
}
