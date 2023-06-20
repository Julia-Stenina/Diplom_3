package ru.yandex.praktikum.stellarBurgers;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class PersonalAccountPage {
  @As("Кнопка [Профиль]")
  private static final SelenideElement userProfileButton = $x(".//a[text()='Профиль']");

  @As("Кнопка [Выход]")
  private static final SelenideElement exitButton = $x(".//button[text()='Выход']");

  @Step("Проверяем наличие кнопки [Профиль]")
  public static void checkUserProfileButtonIsDisplayed(){
    userProfileButton.shouldBe(visible);
  }

  @Step("Нажатие на кнопку [Выход]")
  public static void logOutFromAccount(){
    exitButton.shouldBe(visible).click();
  }
}
