package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfilePage extends BasePage {


    public ProfilePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".text-xl.font-semibold")
    WebElement titleName;

    public ProfilePage verifyUserName(String userName) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(titleName));
        //assertTrue(isContainsText(name,titleName));
        assertTrue(titleName.getText().contains(userName));

        return this;
    }
}
