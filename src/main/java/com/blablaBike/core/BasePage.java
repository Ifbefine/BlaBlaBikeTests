package com.blablaBike.core;


import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public abstract class BasePage {
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected SoftAssertions softly;
    protected Actions actions;
    protected WebDriverWait wait;
    @FindBy(css = "div.text-red-500")
    WebElement alertMessage;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
        this.softly = new SoftAssertions();
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
        }
    }

    public void scrollWithJS(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void clickWithJS(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public void waitOfElementVisibility(WebElement element, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean isContainsText(String text, WebElement element) {
        return element.getText().contains(text);
    }

    public boolean shouldHaveText(WebElement element, String text, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDomAttribute(WebElement element, String attribute) {
        return element.getDomAttribute(attribute);
    }

    public void verifyLink(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            int statusCode = connection.getResponseCode();

            if (statusCode >= 400) {
                softly.fail("URL: " + url + " is BROKEN (Status: " + statusCode + ")");
            } else {
                softly.assertThat(statusCode).isLessThan(400);
            }
        } catch (Exception e) {
            softly.fail("URL: " + url + " - Error occurred: " + e.getMessage());
        }
    }

    public void assertAll() {
        softly.assertAll();
    }

    public String getAlertColor() {
        return alertMessage.getCssValue("color");
    }


}
