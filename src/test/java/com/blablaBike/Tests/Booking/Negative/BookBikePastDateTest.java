package com.blablaBike.Tests.Booking.Negative;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.BookingPage;
import com.blablaBike.pages.CatalogPage;
import com.blablaBike.pages.LoginPage;
import com.blablaBike.pages.window.AddAccessoriesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BookBikePastDateTest extends TestBase {
    LoginPage loginPage;
    CatalogPage catalogPage;
    BookingPage bookingPage;

    AddAccessoriesPage addAccessoriesPage;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();


        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        bookingPage = new BookingPage(driver);

        driver.get("https://blablabike.vercel.app/login");

        loginPage.enterEmail("test123456789@gm.com");
        loginPage.enterPassword("Test123456789@");
        loginPage.clickLoginButton();



        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("profile"));


        driver.get("https://blablabike.vercel.app/catalog");


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("catalog"));

    }
    @Tag("OK")
    @Test
    public void BookBikePastDateTest() throws InterruptedException {
        Thread.sleep(2000);
        catalogPage.openSecondItem();
        Thread.sleep(2000);
        bookingPage.clickOnBookingBtn();
        //  Контакты
        bookingPage.fillContactDetails("Vova", "Testov", "vova@example.com", "+49123456789");

        //  Даты
        bookingPage.entryDate("21", "03", "2015",
                "21", "03", "2016");

        //  Карта
        bookingPage.fillPaymentDetails("4444555566667777", "12/28", "123");

        Thread.sleep(5000);

        //  Финал
        bookingPage.clickConfirmAndPay();

        bookingPage.verifyAnyErrorAlertVisible();
    }
    @Test
    public void BookBikePastDateValidationTest() throws InterruptedException {
        Thread.sleep(2000);
        catalogPage.openSecondItem();
        Thread.sleep(2000);
        bookingPage.clickOnBookingBtn();

        bookingPage.fillContactDetails("Vova", "Testov", "vova@example.com", "+49123456789");


        bookingPage.entryDate("21", "03", "2027", "21", "03", "2025");
        bookingPage.fillPaymentDetails("4444555566667777", "12/28", "123");

        Thread.sleep(300);


        boolean isBtnActive = bookingPage.isConfirmButtonEnabled();
        assertFalse(isBtnActive, "Брешь в безопасности! Кнопка активна при кривых датах.");


        String btnText = bookingPage.getConfirmButtonText();
        assertEquals("SELECT RENTAL DATES", btnText, "Кнопка не поменяла текст на Select Rental Dates");

        System.out.println("Тест прошел: кнопка заблокирована, текст корректен.");
        bookingPage.verifyAnyErrorAlertVisible();

    }
    @Tag("OK")
    @Test
    public void BookBikePastDateInFutureTest() throws InterruptedException {
        Thread.sleep(2000);
        catalogPage.openSecondItem();
        Thread.sleep(2000);
        bookingPage.clickOnBookingBtn();
        // 1. Контакты
        bookingPage.fillContactDetails("Vova", "Testov", "vova@example.com", "+49123456789");

        // 2. Даты
        bookingPage.entryDate("21", "03", "2021",
                "21", "03", "2027");

        // 3. Карта
        bookingPage.fillPaymentDetails("4444555566667777", "12/28", "123");

        Thread.sleep(5000);

        // 4. Финал
        bookingPage.clickConfirmAndPay();
        bookingPage.verifyAnyErrorAlertVisible();

    }

    }

