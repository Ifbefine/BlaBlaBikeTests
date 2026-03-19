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
    private List<WebElement> items;

    public void openSecondItem() {

        for (int i = 0; i < 10; i++) {
            if (items.size() > 1) {
                break;
            }
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

    @FindBy(xpath = "//a[.//img[contains(@src,'placeholder-bike')]]")
    private WebElement itemWithPlaceholder;

    public void openItemWithPlaceholderImage() {

        while (true) {

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a.group")));

            List<WebElement> items = driver.findElements(By.cssSelector("a.group"));

            for (WebElement item : items) {
                WebElement img = item.findElement(By.tagName("img"));
                String src = img.getAttribute("src");

                if (src != null && src.contains("placeholder-bike")) {
                    item.click();
                    return;
                }
            }

            List<WebElement> nextButtons = driver.findElements(By.xpath("//button[.='Next']"));

            if (nextButtons.isEmpty()) {
                break;
            }

            WebElement nextButton = nextButtons.get(0);

            if (!nextButton.isDisplayed() || !nextButton.isEnabled()) {
                break;
            }

            nextButton.click();

            wait.until(ExpectedConditions.stalenessOf(items.get(0)));
        }

        throw new RuntimeException("No item with placeholder image found");
    }


}
