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

public class BookBikeInRepairTest extends TestBase {
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
    @Test
    public void BookBikeInRepairTest() throws InterruptedException {
        Thread.sleep(2000);

        // "In Repair"
        catalogPage.filterByStatus("In Repair");
        Thread.sleep(2000); // Даем фильтру отработать

        // 2
        catalogPage.openSecondItem();

        Thread.sleep(2000);

        // 3.
        bookingPage.clickOnBookingBtn();

        // Заполняем данные
        bookingPage.fillContactDetails("Vova", "RepairCheck", "vova@example.com", "+49123456789");
        bookingPage.entryDate("25", "03", "2026", "26", "03", "2026");
        bookingPage.fillPaymentDetails("4444555566667777", "12/28", "123");

        bookingPage.clickConfirmAndPay();


        Thread.sleep(5000);
    }

}
