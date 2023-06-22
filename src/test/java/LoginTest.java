import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.utills.BrowserConfigurator;

import static com.codeborne.selenide.Selenide.open;
import static ru.yandex.praktikum.stellarBurgers.HeaderPage.clickPersonalAccountButton;
import static ru.yandex.praktikum.stellarBurgers.LoginPage.*;
import static ru.yandex.praktikum.stellarBurgers.MainPage.*;
import static ru.yandex.praktikum.stellarBurgers.RegistryPage.clickLoginButtonOnRegistryPage;
import static ru.yandex.praktikum.stellarBurgers.RestorePasswordPage.*;
import static ru.yandex.praktikum.stellarBurgers.UserClient.*;

public class LoginTest {
  private String nameValue = "Julia";
  private String emailValue = "Julia.H@yandex.ru";
  private String passwordValue = "pass12345";

  @Before
  @Description("Создаем пользователя и открываем сайт")
  public void setup() {
    RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    createUser("{\"email\": \"" + emailValue + "\", \"password\": \"" + passwordValue + "\", " +
            "\"name\": \"" + nameValue + "\"}");
    BrowserConfigurator.setUpBrowser("yandex");
    open("https://stellarburgers.nomoreparties.site/");
  }

  @After
  @Description("Удаляем пользователя")
  public void tearDown() {
    RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    deleteUser("{\"email\": \"" + emailValue + "\", \"password\": \"" + passwordValue + "\"}");
  }

  @Test
  @DisplayName("Check login by login button on main page")
  @Description("Вход по кнопке [Войти в аккаунт] на главной странице")
  public void checkLoginByLoginButtonOnMainPage() {
    clickLoginButtonOnMainPage();
    fillInLoginForm(emailValue, passwordValue);
    checkPlaceOrderButtonIsDisplayed();
  }

  @Test
  @DisplayName("Check login by personal account button")
  @Description("Вход по кнопке [Личный кабинет]")
  public void checkLoginByPersonalAccountButton() {
    clickPersonalAccountButton();
    fillInLoginForm(emailValue, passwordValue);
    checkPlaceOrderButtonIsDisplayed();
  }

  @Test
  @DisplayName("Check login by login button or registry page")
  @Description("Вход через кнопку в форме регистрации")
  public void checkLoginByLoginButtonOnRegistryPage() {
    clickPersonalAccountButton();
    clickRegistryButtonOnLoginPage();
    clickLoginButtonOnRegistryPage();
    fillInLoginForm(emailValue, passwordValue);
    checkPlaceOrderButtonIsDisplayed();
  }

  @Test
  @DisplayName("Check login by button on restore password page")
  @Description("Вход через кнопку в форме восстановления пароля")
  public void checkLoginByButtonOnRestorePasswordPage() {
    clickLoginButtonOnMainPage();
    clickRestorePasswordButton();
    checkRestorePasswordSignIsDisplayed();
    clickLoginButtonOnRestorePasswordPage();
    fillInLoginForm(emailValue, passwordValue);
    checkPlaceOrderButtonIsDisplayed();
  }
}
