import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.utills.BrowserConfigurator;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static ru.yandex.praktikum.stellarBurgers.HeaderPage.*;
import static ru.yandex.praktikum.stellarBurgers.LoginPage.*;
import static ru.yandex.praktikum.stellarBurgers.MainPage.*;
import static ru.yandex.praktikum.stellarBurgers.PersonalAccountPage.*;
import static ru.yandex.praktikum.api.UserClient.*;


public class NavigationTest {

    private String nameValue = "Julia";
    private String emailValue = "Julia.H@yandex.ru";
    private String passwordValue = "pass12345";

    @Before
    @Description("Создаем пользователя, открываем сайт и авторизуемся")
    public void setup() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        createUser("{\"email\": \"" + emailValue + "\", \"password\": \"" + passwordValue + "\", " +
            "\"name\": \"" + nameValue + "\"}");
        BrowserConfigurator.setUpBrowser("yandex");
        open("https://stellarburgers.nomoreparties.site/");
        clickLoginButtonOnMainPage();
        fillInLoginForm(emailValue, passwordValue);
        checkPlaceOrderButtonIsDisplayed();
    }

    @After
    @Description("Удаляем пользователя")
    public void tearDown() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        deleteUser("{\"email\": \"" + emailValue + "\", \"password\": \"" + passwordValue + "\"}");
    }

    @Test
    @DisplayName("Check move to personal account")
    @Description("Переход в личный кабинет")
    public void checkMoveToPersonalAccount() {
        clickPersonalAccountButton();
        checkUserProfileButtonIsDisplayed();
    }

    @Test
    @DisplayName("Check move to constructor")
    @Description("Переход из личного кабинета в конструктор по клику на кнопку [Конструктор]")
    public void checkMoveToConstructor() {
        clickPersonalAccountButton();
        clickConstructorButton();
        checkCreateBurgerSignIsDisplayed();
    }

    @Test
    @DisplayName("Check move to constructor by logo")
    @Description("Переход из личного кабинета в конструктор по клику на логотип [Stellar Burgers]")
    public void checkMoveToConstructorByLogo() {
        clickPersonalAccountButton();
        clickLogoButton();
        checkCreateBurgerSignIsDisplayed();
    }

    @Test
    @DisplayName("Check logout from personal account")
    @Description("Выход из личного кабинета")
    public void checkLogoutFromPersonalAccount() {
        clickPersonalAccountButton();
        logOutFromAccount();
        checkEntranceSignIsDisplayed();
    }

    @Test
    @DisplayName("Check move to section with sauce")
    @Description("Переход к разделу [Соусы]")
    public void checkMoveToSectionSauce() {
        clickSauceButton();
        checkSauceSpicyButtonIsDisplayed();
    }

    @Test
    @DisplayName("Check move to section with filling")
    @Description("Переход к разделу [Начинки]")
    public void checkMoveToSectionFilling() {
        clickFillingButton();
        checkShellfishMeatButtonIsDisplayed();
    }

    @Test
    @DisplayName("Check move to section with bun")
    @Description("Переход к разделу [Булки]")
    public void checkMoveToSectionBun() {
        clickFillingButton();
        sleep(1000);
        clickBunButton();
        checkFluorescentBunButtonIsDisplayed();
    }
}
