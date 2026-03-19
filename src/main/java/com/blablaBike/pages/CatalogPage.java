package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CatalogPage extends BasePage {
 public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.group")
    private List<WebElement> bikeCards;
    @FindBy(css = "div.absolute.top-2.right-2")
    private List<WebElement> bikeStatusLabels;
    @FindBy(css = "select, .filter-select, [role='combobox']")
    private WebElement statusFilter;
    @FindBy(xpath = "//*[contains(text(), 'bikes found') or contains(text(), 'No bikes') or contains(text(), 'found for category')]")
    private WebElement emptyMessage;



    public void waitForCatalogToLoad() {
        wait.until(ExpectedConditions.urlContains("/catalog"));
    }

    public List<String> getAllBikeStatuses() {
        return bikeStatusLabels.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public void selectStatus(String statusText) {
        WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(statusFilter));
        filter.click();

        String optionXpath = String.format(
                "//option[contains(text(), '%s')] | //*[contains(@class, 'option') and contains(text(), '%s')]",
                statusText, statusText
        );
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
        option.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }

    public String getEmptyMessageText() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(emptyMessage)).getText();
        } catch (Exception e) {
            return driver.findElement(By.tagName("body")).getText();
        }
    }

    public boolean noBikesWithStatus(String statusName) {
        return getAllBikeStatuses().stream()
                .noneMatch(s -> s.equalsIgnoreCase(statusName));
    }
}
    @FindBy(xpath = "//select[contains(@class,'bg-gray-100')]")
    WebElement showSelect;

    @FindBy(xpath = "//option[@value='3']")
    WebElement showSelect12;
    @FindBy(xpath = "//*[contains(text(),'TEST')]")
    WebElement addedBikeBrand;



    public CatalogPage waitForCatalogPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("catalog"));
        return this;
    }

    public boolean isBikeAdded() {
        scrollWithJS(0, 1000);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(addedBikeBrand));
        return addedBikeBrand.isDisplayed();
    }
    public CatalogPage verifyAddBike()
    {
        scrollWithJS(0,3000);
        clickWithJS(showSelect);
        clickWithJS(showSelect12);

        return this;
    }
}
