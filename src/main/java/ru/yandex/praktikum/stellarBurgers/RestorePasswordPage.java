package ru.yandex.praktikum.stellarBurgers;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class RestorePasswordPage {

    @As("Надпись [Восстановление пароля]")
    private static final SelenideElement restorePasswordSign = $x(
        ".//h2[text()='Восстановление пароля']");

    @As("Кнопка [Войти]")
    private static final SelenideElement loginButton = $x(".//a[text()='Войти']");

    @Step("Проверяем наличие надписи [Восстановление пароля]")
    public static void checkRestorePasswordSignIsDisplayed() {
        restorePasswordSign.shouldBe(visible);
    }

    @Step("Нажимаем кнопку [Войти]")
    public static void clickLoginButtonOnRestorePasswordPage() {
        loginButton.shouldBe(visible).click();
    }
}
