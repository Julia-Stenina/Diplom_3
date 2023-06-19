package ru.yandex.praktikum.stellarBurgers;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

  @As("Надпись [Вход]")
  private static final SelenideElement entranceSign = $x(".//h2[text()='Вход']");

  @As("Поле [Email]")
  private static final SelenideElement emailField = $x(".//label[text()='Email']/following::input[1]");

  @As("Поле [Пароль]")
  private static final SelenideElement passwordField = $x(".//input[@name='Пароль']");

  @As("Кнопка [Вход]")
  private static final SelenideElement loginButton = $x(".//button[text()='Войти']");

  @As("Кнопка [Зарегистрироваться]")
  private static final SelenideElement registryButton = $x(".//a[text()='Зарегистрироваться']");

  @Step("Проверяем наличие надписи [Вход]")
  public static void checkEntranceSign(){
    entranceSign.shouldBe(visible);
  }

  @Step("Заполняем поле [Email]")
  public static void fillInEmailField(String emailValue){
    emailField.shouldBe(visible).setValue(emailValue);
  }

  @Step("Заполняем поле [Пароль]")
  public static void fillInPasswordField(String passwordValue){
    passwordField.shouldBe(visible).setValue(passwordValue);
  }

  @Step("Нажимаем кнопку [Войти]")
  public static void clickLoginButton(){
    loginButton.shouldBe(visible).click();
  }

  @Step("Нажимаем кнопку [Зарегистрироваться]")
  public static void clickRegistryButton(){
    registryButton.shouldBe(visible).click();
  }

  @Step("Заполняем форму входа")
  public static void fillInLoginForm(String emailValue, String passwordValue){
    checkEntranceSign();
    fillInEmailField(emailValue);
    fillInPasswordField(passwordValue);
    clickLoginButton();
  }
}
