package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPage extends BasePage {

    private final By activeOrdersBadge = By.xpath("//button[contains(., 'Active Orders')]//span");
    private final By activeOrdersTab = By.xpath("//button[contains(., 'Active Orders')]");
    private final By ordersContainer = By.cssSelector("section.grid");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public String getOrdersCountText() {
        WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(activeOrdersBadge));
        return badge.getText();
    }

    public void clickActiveOrdersTab() {
        wait.until(ExpectedConditions.elementToBeClickable(activeOrdersTab)).click();
    }

    public WebElement getOrdersContainer() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ordersContainer));
    }
}