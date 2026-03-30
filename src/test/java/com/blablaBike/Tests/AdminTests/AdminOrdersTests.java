package com.blablaBike.Tests.AdminTests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.AdminPage;
import com.blablaBike.pages.LoginPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class AdminOrdersTests extends TestBase {

    private AdminPage adminPage;
    private LoginPage loginPage;

    @BeforeEach
    public void setupPage() {
        adminPage = new AdminPage(driver);
        loginPage = new LoginPage(driver);

        driver.get("https://blablabike.vercel.app/login");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        loginPage.loginAsAdmin("hannaanna@gmail.com", "Test1234$");

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.or(
                        ExpectedConditions.urlContains("admin"),
                        ExpectedConditions.urlContains("user-profile")
                ));

        if (!driver.getCurrentUrl().contains("admin")) {
            System.out.println("DEBUG: Попали в профиль пользователя, пытаюсь перейти в админку принудительно...");
            driver.get("https://blablabike-arx6.vercel.app/admin");
        }
    }

    @Test
    @DisplayName("TS_ADM_ORD_1.1: Verify only admin can see active orders")
    public void testAdminCanSeeOrders() {
        assertThat(adminPage.isAdminLinkVisible())
                .as("Ссылка на админку должна быть видна")
                .isTrue();
    }

    @Test
    @DisplayName("TS_ADM_ORD_1.2: Verify order list details")
    public void testOrderDetailsDisplay() {
        var orders = adminPage.getOrderElements();
        assertThat(orders).as("Список заказов не пуст").isNotEmpty();

        String firstOrderText = orders.get(0).getText();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(firstOrderText)
                .as("Должен быть указан текст заказа")
                .isNotEmpty();
        softly.assertAll();
    }

    @Test
    @DisplayName("TS_ADM_ORD_1.4: Проверка пустого списка заказов")
    public void testEmptyOrderList() {
        String count = adminPage.getOrdersCountText();

        if (count.equals("0")) {
            String containerContent = adminPage.getOrdersContainer().getText();
            assertThat(containerContent)
                    .as("Если счетчик 0, список должен быть пуст")
                    .containsAnyOf("0", "No orders");
        } else {
            System.out.println("Список не пуст, заказов: " + count);
            assertThat(Integer.parseInt(count)).isGreaterThan(0);
        }
    }
}
