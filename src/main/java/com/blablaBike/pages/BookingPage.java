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
    @FindBy(xpath = "//button[contains(text(), 'Book Now')]")
    private WebElement bookBtn;
    public void clickOnBookingBtn() {
        waitOfElementVisibility(bookBtn,5);
        bookBtn.click();

    }
    @FindBy(xpath = "//input[@placeholder='datetime start']")
    private WebElement startDateInput;

    @FindBy(xpath = "//input[@placeholder='datetime end']")
    private WebElement endDateInput;

    public void entryDate(String d1, String m1, String y1, String d2, String m2, String y2) {
        // Формат теперь строго YYYY-MM-DD
        String startIso = String.format("%s-%s-%s", y1, m1, d1);
        String endIso = String.format("%s-%s-%s", y2, m2, d2);

        JavascriptExecutor js = (JavascriptExecutor) driver;


        String smartSet =
                "var setValue = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
                        "setValue.call(arguments[0], arguments[1]);" +
                        "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
                        "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));";

        wait.until(ExpectedConditions.visibilityOf(startDateInput));


        js.executeScript(smartSet, startDateInput, startIso);
        js.executeScript(smartSet, endDateInput, endIso);
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
    @FindBy(xpath = "//p[text()='Lock']/ancestor::label//input")
    private WebElement lockCheckbox;

    @FindBy(xpath = "//p[text()=' Insurance']/ancestor::label//input")
    private WebElement insuranceCheckbox;

    @FindBy(xpath = "//p[text()='Helmet']/ancestor::label//input")
    private WebElement helmetCheckbox;

    // Метод для выбора всех аксессуаров
    public void selectAllAccessories() {
        wait.until(ExpectedConditions.elementToBeClickable(lockCheckbox));
        if (!lockCheckbox.isSelected()) lockCheckbox.click();
        if (!insuranceCheckbox.isSelected()) insuranceCheckbox.click();
        if (!helmetCheckbox.isSelected()) helmetCheckbox.click();
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
    public void multiClickConfirm(int count) {
        wait.until(ExpectedConditions.elementToBeClickable(confirmPayBtn));
        for (int i = 0; i < count; i++) {
            confirmPayBtn.click();
            System.out.println("Отправлен клик №" + (i + 1));
        }
    }

    public void clickConfirmAndPay() {
        confirmPayBtn.click();
    }

    // Самый надежный путь: кнопка внутри div, где заголовок "Order Summary"
    @FindBy(xpath = "//h2[text()='Order Summary']/following-sibling::button")
    private WebElement confirmPayBtnIfInactive;
    public boolean isConfirmButtonEnabled() {
        return confirmPayBtnIfInactive.isEnabled();
    }
    public String getConfirmButtonText() {
        return confirmPayBtnIfInactive.getText();
    }
}

