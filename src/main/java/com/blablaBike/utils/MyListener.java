package com.blablaBike.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

public class MyListener implements WebDriverListener {
    private static final Logger logger = LoggerFactory.getLogger(MyListener.class);



    // Этот метод сработает ДО клика по любому элементу
    @Override
    public void beforeClick(WebElement element) {
        logger.info(" Попытка клика по элементу: " + getElementDescription(element));
    }

    // Этот метод сработает ПОСЛЕ клика
    @Override
    public void afterClick(WebElement element) {
        logger.info(" Клик выполнен успешно");
    }

    // Логируем ввод текста
    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        logger.info("Ввожу текст [" + String.join("", keysToSend) + "] в элемент: " + getElementDescription(element));
    }

    // Если случится ошибка — она тоже попадет в лог!
    @Override
    public void onError(Object target, java.lang.reflect.Method method, Object[] args, InvocationTargetException e) {
        logger.error(" ОШИБКА в методе " + method.getName() + ": " + e.getTargetException().getMessage());
    }

    // Вспомогательный метод, чтобы лог был читаемым
    private String getElementDescription(WebElement element) {
        String desc = element.toString();
        if (desc.contains("->")) {
            return desc.substring(desc.lastIndexOf("->") + 2, desc.length() - 1);
        }
        return desc;
    }
}