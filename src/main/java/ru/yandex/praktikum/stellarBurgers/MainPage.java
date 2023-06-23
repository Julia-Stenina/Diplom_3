package ru.yandex.praktikum.stellarBurgers;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @As("Кнопка [Войти в аккаунт]")
    private static final SelenideElement logInAccount = $x(".//button[text()='Войти в аккаунт']");

    @As("Кнопка [Оформить заказ]")
    private static final SelenideElement placeOrderButton = $x(
        ".//button[text()='Оформить заказ']");

    @As("Надпись [Соберите бургер]")
    private static final SelenideElement createBurgerSign = $x(".//h1[text()='Соберите бургер']");

    @As("Кнопка [Булки]")
    private static final SelenideElement bunButton = $x(".//span[text()='Булки']");

    @As("Кнопка [Соусы]")
    private static final SelenideElement sauceButton = $x(".//span[text()='Соусы']");

    @As("Кнопка [Начинки]")
    private static final SelenideElement fillingButton = $x(".//span[text()='Начинки']");

    @As("Кнопка [Флюоресцентная булка]")
    private static final SelenideElement fluorescentBunButton = $x(
        ".//p[text()='Флюоресцентная булка R2-D3']");

    @As("Кнопка [Соус Spicy-X]")
    private static final SelenideElement sauceSpicyButton = $x(".//p[text()='Соус Spicy-X']");

    @As("Кнопка [Мясо бессмертных моллюсков Protostomia]")
    private static final SelenideElement shellfishMeatButton = $x(
        ".//p[text()='Мясо бессмертных моллюсков Protostomia']");

    @Step("Нажимаем на кнопку [Войти в аккаунт]")
    public static void clickLoginButtonOnMainPage() {
        logInAccount.shouldBe(visible).click();
    }

    @Step("Проверяем наличие кнопки [Оформить заказ]")
    public static void checkPlaceOrderButtonIsDisplayed() {
        placeOrderButton.shouldBe(visible);
    }

    @Step("Проверяем наличие надписи [Соберите бургер]")
    public static void checkCreateBurgerSignIsDisplayed() {
        createBurgerSign.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку [Булки]")
    public static void clickBunButton() {
        bunButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку [Соусы]")
    public static void clickSauceButton() {
        sauceButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку [Начинки]")
    public static void clickFillingButton() {
        fillingButton.shouldBe(visible).click();
    }

    @Step("Проверяем наличие кнопки [Флюоресцентная булка]")
    public static void checkFluorescentBunButtonIsDisplayed() {
        fluorescentBunButton.shouldBe(visible);
    }

    @Step("Проверяем наличие кнопки [Соус Spicy-X]")
    public static void checkSauceSpicyButtonIsDisplayed() {
        sauceSpicyButton.shouldBe(visible);
    }

    @Step("Проверяем наличие кнопки [Мясо бессмертных моллюсков Protostomia]")
    public static void checkShellfishMeatButtonIsDisplayed() {
        shellfishMeatButton.shouldBe(visible);
    }
}
