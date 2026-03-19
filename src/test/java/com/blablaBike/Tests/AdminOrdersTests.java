package com.blablaBike.Tests;

import com.blablaBike.core.TestBase;
import com.blablaBike.pages.AdminPage;
import com.blablaBike.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdminOrdersTests extends TestBase {

    private AdminPage adminPage;
    private LoginPage loginPage;

    @BeforeEach
    public void setupPage() {
        driver.get("https://blablabike-arx6.vercel.app/login");
        adminPage = new AdminPage(this.driver);
        loginPage = new LoginPage(this.driver);
        loginPage.loginAsAdmin();
    }

    @Test
    @DisplayName("TS_ADM_ORD_1.4: Проверка пустого списка заказов")
    public void testEmptyOrderList() {
        String count = adminPage.getOrdersCountText();
        assertThat(count)
                .as("Счетчик заказов должен быть 0")
                .isEqualTo("0");

        adminPage.clickActiveOrdersTab();

        String containerContent = adminPage.getOrdersContainer().getText();
        assertThat(containerContent)
                .as("Список заказов должен быть пуст (содержать 0)")
                .contains("0");
    }
}