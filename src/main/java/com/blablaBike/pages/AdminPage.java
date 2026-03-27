package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AdminPage extends BasePage {

    // Локаторы на основе скриншота верстки
    private final By activeOrdersCount = By.xpath("//p[text()='Active Orders']/following-sibling::h2");
    private final By adminLink = By.xpath("//a[@href='/admin']");
    // Секция со списком заказов (нижняя часть экрана)
    private final By ordersSection = By.cssSelector("div.overflow-y-auto");
    private final By orderItems = By.cssSelector("div.overflow-y-auto > div");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAdminLinkVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(adminLink)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getOrdersCountText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(activeOrdersCount)).getText();
    }

    public List<WebElement> getOrderElements() {
        return driver.findElements(orderItems);
    }

    public WebElement getOrdersContainer() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ordersSection));
    }
}