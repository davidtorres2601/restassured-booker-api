package tests;

import base.BaseTest;
import io.restassured.response.Response;
import models.AuthRequest;
import org.junit.jupiter.api.Test;
import services.AuthService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTest extends BaseTest {

    @Test
    void shouldCreateToken() {

        AuthRequest request =
                new AuthRequest("admin", "password123");

        AuthService authService = new AuthService();

        var response = authService.createToken(request);

        assertEquals(200, response.statusCode());

        System.out.println(response.asPrettyString());

    }

    @Test
    void shouldFailCreateToken() {

        AuthService authService = new AuthService();

        AuthRequest request =
                new AuthRequest("admin", "incorrecto");

        Response response = authService.createToken(request);

        assertEquals(200, response.statusCode());

        assertEquals(
                "Bad credentials",
                response.jsonPath().getString("reason")
        );

    }

}