package ru.yandex.praktikum.stellarBurgers;

import com.codeborne.selenide.As;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class RegistryPage {

  @As("Заголовок [Регистрация]")
  private final SelenideElement registryHeader = $x(".//h2[text()='Регистрация']");

  @As("Поле [Имя]")
  private static final SelenideElement nameField = $x(".//label[text()='Имя']/following::input[1]");

  @As("Поле [Email]")
  private static final SelenideElement emailField = $x(".//label[text()='Email']/following::input[1]");

  @As("Поле [Пароль]")
  private static final SelenideElement passwordField = $x(".//input[@name='Пароль']");

  @As("Надпись [Некорректный пароль]")
  private static final SelenideElement wrongPasswordSign = $x(".//p[text()='Некорректный пароль']");

  @As("Кнопка [Зарегистрироваться]")
  private static final SelenideElement registryButton = $x(".//button[text()='Зарегистрироваться']");

  @As("Кнопка [Войти]")
  private static final SelenideElement loginButton = $x(".//a[text()='Войти']");

  @Step("Заполняем поле [Имя]")
  public static void fillInNameField(String nameValue){
    nameField.shouldBe(visible).setValue(nameValue);
  }

  @Step("Заполняем поле [Email]")
  public static void fillInEmailField(String emailValue){
    emailField.shouldBe(visible).setValue(emailValue);
  }

  @Step("Заполняем поле [Пароль]")
  public static void fillInPasswordField(String passwordValue){
    passwordField.shouldBe(visible).setValue(passwordValue);
  }

  @Step("Проверяем наличие надписи [Некорректный пароль]")
  public static void checkWrongPassSign(){
    wrongPasswordSign.shouldBe(exist);
  }

  @Step("Нажимаем кнопку [Зарегистрироваться]")
  public static void clickRegistryButton(){
    registryButton.shouldBe(visible).click();
  }

  @Step("Нажимаем кнопку [Войти]")
  public static void clickLoginButton(){
    loginButton.shouldBe(visible).click();
  }

  @Step("Заполняем форму регистрации")
  public static void fillInRegistryForm(String nameValue, String emailValue, String passwordValue){
    fillInNameField(nameValue);
    fillInEmailField(emailValue);
    fillInPasswordField(passwordValue);
    clickRegistryButton();
  }
}
