import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.utills.BrowserConfigurator;
import ru.yandex.praktikum.utills.DeleteUser;

import static com.codeborne.selenide.Selenide.open;
import static ru.yandex.praktikum.stellarBurgers.LoginPage.*;
import static ru.yandex.praktikum.stellarBurgers.MainPage.*;
import static ru.yandex.praktikum.stellarBurgers.RegistryPage.*;

public class RegistryTest extends DeleteUser {

    private String nameValue = "Julia";
    private String emailValue = "Julia.H@yandex.ru";
    private String correctPassword = "pass12345";
    private String wrongPassword = "12345";

    @Before
    @Description("Открываем сайт")
    public void setUp() {

        BrowserConfigurator.setUpBrowser("yandex");
        open("https://stellarburgers.nomoreparties.site/");
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
