package com.blablaBike.pages;

import com.blablaBike.core.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {
  
     WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "email")
    WebElement emailField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(xpath = "//button[contains(text(), 'Log In')]")
    WebElement loginButton;


    public void enterEmail(String email) {
        emailField.sendKeys(email);

    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }

    public String getEmailErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));


        WebElement errorElement = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Invalid email address')]")
        ));

        return errorElement.getText();
    }

    public String getPasswordInputType() {

        return passwordField.getAttribute("type");
    }
  
  
    private final By emailField = By.cssSelector("input[type='email']");
    private final By passwordField = By.cssSelector("input[type='password']");

    private final By loginButton = By.cssSelector("button[type='submit']");

    private final By signOutButton = By.xpath("//button[contains(text(), 'Sign Out')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginAsAdmin() {
        boolean isAlreadyLoggedIn = driver.findElements(signOutButton).size() > 0;

        if (isAlreadyLoggedIn) {
            System.out.println("✅ Сессия активна, пропускаем ввод данных.");
            return;
        }

        System.out.println("🔑 Выполняю вход...");

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField))
                .sendKeys("admin@test.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField))
                .sendKeys("admin123");

        wait.until(ExpectedConditions.elementToBeClickable(loginButton))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButton));
        System.out.println("🎉 Вход выполнен успешно!");
       
    }
}


