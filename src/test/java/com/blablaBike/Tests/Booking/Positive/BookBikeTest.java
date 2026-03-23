package com.blablaBike.Tests.Booking.Positive;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.BookingPage;
import com.blablaBike.pages.CatalogPage;
import com.blablaBike.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookBikeTest extends TestBase {

    LoginPage loginPage;
    CatalogPage catalogPage;
    BookingPage bookingPage;

    @BeforeEach
    public void setUp() {
        // 2. Сначала создаем драйвер
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 3. ТЕПЕРЬ создаем объекты страниц, передавая им готовый драйвер
        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        bookingPage = new BookingPage(driver);

        driver.get("https://blablabike-arx6.vercel.app/login");

        loginPage.enterEmail("test123456789@gm.com");
        loginPage.enterPassword("Test123456789@");
        loginPage.clickLoginButton();


        // 1. ЖДЕМ, пока загрузится профиль.
        // Это гарантирует, что сервер прислал куки и браузер их сохранил.
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("profile"));

        // 2. Теперь, когда мы точно залогинены, прыгаем в каталог
        driver.get("https://blablabike-arx6.vercel.app/catalog");

        // 3. (Опционально) Убедимся, что каталог открылся
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("catalog"));

    }

    @Test
    public void SuccessfullBookingTest() throws InterruptedException {
        Thread.sleep(2000);
        catalogPage.openSecondItem();
        Thread.sleep(2000);
        bookingPage.clickOnBookingBtn();

        // 1. Контакты
        bookingPage.fillContactDetails("Vova", "Testov", "vova@example.com", "+49123456789");

        // 2. Даты (используем тот "умный" JS метод, чтобы не стирались!)
        bookingPage.entryDate("25", "03", "2026", "14", "00",
                "26", "03", "2026", "15", "30");

        // 3. Карта
        bookingPage.fillPaymentDetails("4444555566667777", "12/28", "123");

        Thread.sleep(5000); // Даем время посмотреть, что всё заполнено

        // 4. Финальный аккорд!
        bookingPage.clickConfirmAndPay();
        Thread.sleep(10000);
    }
}
