package com.blablaBike.utils;

import org.openqa.selenium.WebDriver;

public class AdminPageHelper {

    private WebDriver driver;

    public AdminPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void changeBikeStatusInDB(String status) {
        System.out.println("Change bike status in DB to: " + status);
    }
}