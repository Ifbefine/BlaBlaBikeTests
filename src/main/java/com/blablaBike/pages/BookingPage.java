package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingPage extends BasePage {

    public BookingPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[text()='Book Now']")
    private WebElement bookBtn;
    public void clickOnBookingBtn() {
        waitOfElementVisibility(bookBtn,5);
        bookBtn.click();

    }
    @FindBy(xpath = "//input[@placeholder='datetime start']")
    private WebElement startDateInput;

    @FindBy(xpath = "//input[@placeholder='datetime end']")
    private WebElement endDateInput;

    public void entryDate(String d1, String m1, String y1, String h1, String min1,
                          String d2, String m2, String y2, String h2, String min2) {

        String startIso = String.format("%s-%s-%sT%s:%s", y1, m1, d1, h1, min1);
        String endIso = String.format("%s-%s-%sT%s:%s", y2, m2, d2, h2, min2);

        JavascriptExecutor js = (JavascriptExecutor) driver;


        String smartSet =
                "var setValue = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
                        "setValue.call(arguments[0], arguments[1]);" +
                        "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
                        "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));";


        wait.until(ExpectedConditions.visibilityOf(startDateInput));


        js.executeScript(smartSet, startDateInput, startIso);
        js.executeScript(smartSet, endDateInput, endIso);


        startDateInput.click();
        endDateInput.click();
    }
    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    // Метод для заполнения данных пользователя
    public void fillContactDetails(String fName, String lName, String email, String phone) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.sendKeys(fName);
        lastNameInput.sendKeys(lName);
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phone);

    }
    @FindBy(xpath = "//input[@placeholder='0000 0000 0000 0000']")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//input[@placeholder='MM/YY']")
    private WebElement cardExpiryInput;

    @FindBy(xpath = "//input[@placeholder='123']")
    private WebElement cardCvcInput;

    @FindBy(xpath = "//button[contains(text(), 'Confirm & Pay')]")
    private WebElement confirmPayBtn;

    // Метод для заполнения карты
    public void fillPaymentDetails(String number, String expiry, String cvc) {
        wait.until(ExpectedConditions.visibilityOf(cardNumberInput));
        cardNumberInput.sendKeys(number);
        cardExpiryInput.sendKeys(expiry);
        cardCvcInput.sendKeys(cvc);
    }

    public void clickConfirmAndPay() {
        confirmPayBtn.click();
    }
}
