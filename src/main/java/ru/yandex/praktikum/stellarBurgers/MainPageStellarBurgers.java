package ru.yandex.praktikum.stellarBurgers;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPageStellarBurgers {

  @As("Кнопка [Личный кабинет]")
  private static final SelenideElement personalAccount = $x(".//p[text()='Личный Кабинет']");

  @As("Кнопка [Войти в аккаунт]")
  private static final SelenideElement logInAccount = $x(".//button[text()='Войти в аккаунт']");

  @As("Кнопка [Оформить заказ]")
  private static final SelenideElement placeOrderButton = $x(".//button[text()='Оформить заказ']");

  @Step("Нажимаем на кнопку [Личный кабинет]")
  public static void clickPersonalAccountButton(){
    personalAccount.shouldBe(visible).click();
  }

  @Step("Нажимаем на кнопку [Войти в аккаунт]")
  public static void clickLogInButton(){
    logInAccount.shouldBe(visible).click();
  }

  @Step("Проверяем наличие кнопки [Оформить заказ]")
  public static void checkPlaceOrderButton(){
    placeOrderButton.shouldBe(visible);
  }
}
