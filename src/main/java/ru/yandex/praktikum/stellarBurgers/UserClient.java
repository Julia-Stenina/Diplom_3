package ru.yandex.praktikum.stellarBurgers;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

  @Step("Создаём пользователя")
  public static void createUser(String json) {
    given().header("Content-type", "application/json")
            .and()
            .body(json)
            .when()
            .post("/api/auth/register");
  }

  @Step("Удаляем пользователя")
  public static void deleteUser(String json) {
    Response response = given().header("Content-type", "application/json").and().body(json)
            .when().post("/api/auth/login");
    int code = response.statusCode();
    if (code == 200) {
      String userToken = response.jsonPath().getString("accessToken");
      given().header("Authorization", userToken).and()
              .delete("/api/auth/user/");
    }
  }
}
