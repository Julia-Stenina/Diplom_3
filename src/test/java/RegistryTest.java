import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static ru.yandex.praktikum.stellarBurgers.LoginPage.*;
import static ru.yandex.praktikum.stellarBurgers.MainPage.*;
import static ru.yandex.praktikum.stellarBurgers.RegistryPage.*;
import static ru.yandex.praktikum.stellarBurgers.UserClient.deleteUser;

public class RegistryTest {

  private String nameValue = "Julia";
  private String emailValue = "Julia.H@yandex.ru";
  private String correctPassword = "pass12345";
  private String wrongPassword = "12345";

  @Before
  @Description("Открываем сайт")
  public void setUp() {
    open("https://stellarburgers.nomoreparties.site/");
  }

  @After
  @Description("Удаляем пользователя")
  public void tearDown() {
    RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    deleteUser("{\"email\": \"" + emailValue + "\", \"password\": \"" + correctPassword + "\"}");
  }

  @Test
  @DisplayName("Check success registry")
  @Description("Проверяем успешную регистрацию пользователя")
  public void checkSuccessfulRegistry() {
    clickLoginButtonOnMainPage();
    clickRegistryButtonOnLoginPage();
    fillInRegistryForm(nameValue, emailValue, correctPassword);
    fillInLoginForm(emailValue, correctPassword);
    checkPlaceOrderButtonIsDisplayed();
  }

  @Test
  @DisplayName("Check registry with wrong password")
  @Description("Проверяем регистрацию пользователя с некорректным паролем")
  public void checkRegistryWIthWrongPassword() {
    clickLoginButtonOnMainPage();
    clickRegistryButtonOnLoginPage();
    fillInRegistryForm(nameValue, emailValue, wrongPassword);
    checkWrongPassSignIsDisplayed();
  }
}
