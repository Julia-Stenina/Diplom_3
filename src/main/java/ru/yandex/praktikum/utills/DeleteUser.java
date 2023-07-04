package ru.yandex.praktikum.utills;

import static ru.yandex.praktikum.api.UserClient.deleteUser;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.junit.After;
import ru.yandex.praktikum.api.LoginUserPayload;

public class DeleteUser {

    @After
    @Description("Удаляем пользователя")
    public void tearDown() {
        String email = "Julia.H@yandex.ru";
        String password = "pass12345";
        LoginUserPayload loginUserPayload = new LoginUserPayload(email, password);
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        deleteUser(loginUserPayload);
    }

}
