package tests;

import base.BaseTest;
import io.restassured.response.Response;
import models.AuthRequest;
import org.junit.jupiter.api.Test;
import services.AuthService;
import services.BookingService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingTest extends BaseTest {

    @Test
    void shouldGetBooking() {

        BookingService bookingService = new BookingService();

        // Crear una reserva
        Response createResponse = bookingService.createBooking();

        int bookingId = createResponse
                .jsonPath()
                .getInt("bookingid");

        // Consultar la reserva
        Response getResponse = bookingService.getBooking(bookingId);

        assertEquals(200, getResponse.statusCode());

        assertEquals(
                "David",
                getResponse.jsonPath().getString("firstname")
        );

        System.out.println(getResponse.asPrettyString());
    }

    @Test
    void shouldUpdateBooking() {

        // Obtener token
        AuthService authService = new AuthService();

        AuthRequest authRequest =
                new AuthRequest("admin", "password123");

        String token = authService
                .createToken(authRequest)
                .jsonPath()
                .getString("token");

        BookingService bookingService = new BookingService();

        // Crear reserva
        Response createResponse = bookingService.createBooking();

        int bookingId = createResponse
                .jsonPath()
                .getInt("bookingid");

        // Actualizar reserva
        Response updateResponse =
                bookingService.updateBooking(bookingId, token);

        assertEquals(200, updateResponse.statusCode());

        assertEquals(
                "David Actualizado",
                updateResponse.jsonPath().getString("firstname")
        );

        System.out.println(updateResponse.asPrettyString());
    }

}