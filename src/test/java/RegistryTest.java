import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.stellarBurgers.LoginPage;
import ru.yandex.praktikum.stellarBurgers.MainPageStellarBurgers;
import ru.yandex.praktikum.stellarBurgers.RegistryPage;
import ru.yandex.praktikum.stellarBurgers.UserClient;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class RegistryTest {

  private String nameValue = "Julia";
  private String emailValue = "Julia.H@yandex.ru";
  private String correctPassword = "pass12345";
  private String wrongPassword = "12345";

  @Before
  public void setUp(){
    open("https://stellarburgers.nomoreparties.site/");
  }

  @After
  public void deleteUser() {
    RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    UserClient.deleteUser("{\"email\": \"" + emailValue + "\", \"password\": \"" + correctPassword + "\"}");
  }

  @Test
  @Step("Проверяем успешную регистрацию пользователя")
  public void checkSuccessfulRegistry() {
    MainPageStellarBurgers.clickLogInButton();
    LoginPage.clickRegistryButton();
    RegistryPage.fillInRegistryForm(nameValue, emailValue, correctPassword);
    LoginPage.fillInLoginForm(emailValue, correctPassword);
    MainPageStellarBurgers.checkPlaceOrderButton();
  }

  @Test
  @Step("Проверяем регистрацию пользователя с некорректным паролем")
  public void checkRegistryWIthWrongPassword(){
    MainPageStellarBurgers.clickLogInButton();
    LoginPage.clickRegistryButton();
    RegistryPage.fillInRegistryForm(nameValue, emailValue, wrongPassword);
    RegistryPage.checkWrongPassSign();
  }
}
