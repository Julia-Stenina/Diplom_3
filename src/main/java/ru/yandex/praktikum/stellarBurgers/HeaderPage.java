package ru.yandex.praktikum.stellarBurgers;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderPage {

    @As("Кнопка [Личный кабинет]")
    private static final SelenideElement personalAccount = $x(".//p[text()='Личный Кабинет']");

    @As("Кнопка [Конструктор]")
    private static final SelenideElement constructorButton = $x(".//p[text()='Конструктор']");

    @As("Логотип [Stellar Burgers]")
    private static final SelenideElement logoButton = $x(".//div/a");

    @Step("Нажимаем на кнопку [Личный кабинет]")
    public static void clickPersonalAccountButton() {
        personalAccount.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку [Конструктор]")
    public static void clickConstructorButton() {
        constructorButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на логотип [Stellar Burgers]")
    public static void clickLogoButton() {
        logoButton.shouldBe(visible).click();
    }
}
