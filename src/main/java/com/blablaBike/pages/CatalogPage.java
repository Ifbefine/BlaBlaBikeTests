package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends BasePage {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.group")
    private List<WebElement> items;

    public void openSecondItem() {

        // wait until items are loaded
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

        // wait for item page to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}