import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.stellarBurgers.LoginPage;
import ru.yandex.praktikum.stellarBurgers.MainPageStellarBurgers;
import ru.yandex.praktikum.stellarBurgers.RegistryPage;
import ru.yandex.praktikum.stellarBurgers.UserClient;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
  private String nameValue = "Julia";
  private String emailValue = "Julia.H@yandex.ru";
  private String passwordValue = "pass12345";

  @Before
  public void setup() {
    RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    UserClient userClient = new UserClient();
    userClient.createUser("{\"email\": \"" + emailValue + "\", \"password\": \"" + passwordValue + "\", " +
            "\"name\": \"" + nameValue + "\"}");
    open("https://stellarburgers.nomoreparties.site/");
  }

  @After
  public void deleteUser() {
    RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    UserClient.deleteUser("{\"email\": \"" + emailValue + "\", \"password\": \"" + passwordValue + "\"}");
  }

  @Test
  @Step("Вход по кнопке [Войти в аккаунт] на главной странице")
  public void loginByLoginButtonOnMainPage(){
    MainPageStellarBurgers.clickLogInButton();
    LoginPage.fillInLoginForm(emailValue, passwordValue);
    MainPageStellarBurgers.checkPlaceOrderButton();
  }

  @Test
  @Step("Вход по кнопке [Личный кабинет]")
  public void loginByPersonalAccountButton(){
    MainPageStellarBurgers.clickPersonalAccountButton();
    LoginPage.fillInLoginForm(emailValue, passwordValue);
    MainPageStellarBurgers.checkPlaceOrderButton();
  }

  @Test
  @Step("Вход через кнопку в форме регистрации")
  public void loginByLoginButtonOnRegistryPage(){
    MainPageStellarBurgers.clickPersonalAccountButton();
    LoginPage.clickRegistryButton();
    RegistryPage.clickLoginButton();
    LoginPage.fillInLoginForm(emailValue, passwordValue);
    MainPageStellarBurgers.checkPlaceOrderButton();
  }
}
