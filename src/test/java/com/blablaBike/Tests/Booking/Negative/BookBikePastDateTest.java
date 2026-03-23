package com.blablaBike.Tests.Booking.Negative;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.BookingPage;
import com.blablaBike.pages.CatalogPage;
import com.blablaBike.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookBikePastDateTest extends TestBase {
    LoginPage loginPage;
    CatalogPage catalogPage;
    BookingPage bookingPage;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();


        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        bookingPage = new BookingPage(driver);

        driver.get("https://blablabike-arx6.vercel.app/login");

        loginPage.enterEmail("test123456789@gm.com");
        loginPage.enterPassword("Test123456789@");
        loginPage.clickLoginButton();



        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("profile"));


        driver.get("https://blablabike-arx6.vercel.app/catalog");


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("catalog"));

    }
    @Tag("NOT WORKING/bug")
    @Test
    public void BookBikePastDateTest() throws InterruptedException {
        Thread.sleep(2000);
        catalogPage.openSecondItem();
        Thread.sleep(2000);
        bookingPage.clickOnBookingBtn();
        //  Контакты
        bookingPage.fillContactDetails("Vova", "Testov", "vova@example.com", "+49123456789");

        //  Даты
        bookingPage.entryDate("21", "03", "2023", "14", "00",
                "21", "03", "2024", "15", "30");

        //  Карта
        bookingPage.fillPaymentDetails("4444555566667777", "12/28", "123");

        Thread.sleep(5000);

        //  Финал
        bookingPage.clickConfirmAndPay();
        Thread.sleep(10000);
    }
    @Tag("NOT WORKING/bug")
    @Test
    public void BookBikeFutureDateTest() throws InterruptedException {
        Thread.sleep(2000);
        catalogPage.openSecondItem();
        Thread.sleep(2000);
        bookingPage.clickOnBookingBtn();
        // 1. Контакты
        bookingPage.fillContactDetails("Vova", "Testov", "vova@example.com", "+49123456789");

        // 2. Даты
        bookingPage.entryDate("21", "03", "2027", "14", "00",
                "21", "03", "2025", "15", "30");

        // 3. Карта
        bookingPage.fillPaymentDetails("4444555566667777", "12/28", "123");

        Thread.sleep(5000);

        // 4. Финал
        bookingPage.clickConfirmAndPay();
        Thread.sleep(10000);
    }
    @Tag("NOT WORKING/bug")
    @Test
    public void BookBikePastDateInFutureTest() throws InterruptedException {
        Thread.sleep(2000);
        catalogPage.openSecondItem();
        Thread.sleep(2000);
        bookingPage.clickOnBookingBtn();
        // 1. Контакты
        bookingPage.fillContactDetails("Vova", "Testov", "vova@example.com", "+49123456789");

        // 2. Даты
        bookingPage.entryDate("21", "03", "2021", "14", "00",
                "21", "03", "2027", "15", "30");

        // 3. Карта
        bookingPage.fillPaymentDetails("4444555566667777", "12/28", "123");

        Thread.sleep(5000);

        // 4. Финал
        bookingPage.clickConfirmAndPay();
        Thread.sleep(10000);
    }

    }

