package services;

import io.restassured.http.ContentType;
import models.AuthRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthService {

    public Response createToken(AuthRequest request) {

        return given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/auth")
                .then()
                .extract()
                .response();
    }

}