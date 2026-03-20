package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogPage extends BasePage {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    // --- Darina Section ---
    @FindBy(css = "a.group")
    private List<WebElement> items;

    @FindBy(xpath = "//a[.//img[contains(@src,'placeholder-bike')]]")
    private WebElement itemWithPlaceholder;

    public void openSecondItem() {
        for (int i = 0; i < 10; i++) {
            if (items.size() > 1) break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (items.size() > 1) {
            items.get(1).click();
        } else {
            throw new RuntimeException("Items were not loaded");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openItemWithPlaceholderImage() {
        while (true) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a.group")));
            List<WebElement> currentItems = driver.findElements(By.cssSelector("a.group"));

            for (WebElement item : currentItems) {
                WebElement img = item.findElement(By.tagName("img"));
                String src = img.getAttribute("src");

                if (src != null && src.contains("placeholder-bike")) {
                    item.click();
                    return;
                }
            }

            List<WebElement> nextButtons = driver.findElements(By.xpath("//button[.='Next']"));
            if (nextButtons.isEmpty()) break;

            WebElement nextButton = nextButtons.get(0);
            if (!nextButton.isDisplayed() || !nextButton.isEnabled()) break;

            nextButton.click();
            wait.until(ExpectedConditions.stalenessOf(currentItems.get(0)));
        }
        throw new RuntimeException("No item with placeholder image found");
    }

    // --- Dariia Section ---
    @FindBy(xpath = "//select[contains(@class,'bg-gray-100')]")
    private WebElement showSelect;

    @FindBy(xpath = "//option[@value='Все']")
    private WebElement showSelect12;

    @FindBy(xpath = "//*[contains(text(),'TEST')]")
    private WebElement addedBikeBrand;

    public CatalogPage waitForCatalogPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("catalog"));
        return this;
    }

    public boolean isBikeAdded() {
        By bikeLocator = By.xpath("//*[text()='TEST']");;

        // первая попытка поиска
        for (int i = 0; i < 5; i++) {
            if (!driver.findElements(bikeLocator).isEmpty()) {
                WebElement bike = driver.findElement(bikeLocator);
                js.executeScript("arguments[0].scrollIntoView({block:'center'});", bike);
                return bike.isDisplayed();
            }

            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            pause(500);
        }

        // прокручиваем к select
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", showSelect);
        wait.until(ExpectedConditions.visibilityOf(showSelect));

        Select select = new Select(showSelect);
        select.selectByVisibleText("Все");

        // ждём, что значение реально выбралось
        wait.until(driver ->
                new Select(showSelect).getFirstSelectedOption().getText().trim().equals("Все")
        );

        // после выбора "Все" начинаем поиск заново
        for (int i = 0; i < 8; i++) {
            if (!driver.findElements(bikeLocator).isEmpty()) {
                WebElement bike = driver.findElement(bikeLocator);
                js.executeScript("arguments[0].scrollIntoView({block:'center'});", bike);
                wait.until(ExpectedConditions.visibilityOf(bike));
                return true;
            }

            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            pause(500);
        }

        return false;

    }


    public CatalogPage verifyAddBike() {
        scrollWithJS(0, 3000);
        clickWithJS(showSelect);
        clickWithJS(showSelect12);
        return this;
    }

    // --- Anna Section ---
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
        } catch (InterruptedException ignored) {}
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