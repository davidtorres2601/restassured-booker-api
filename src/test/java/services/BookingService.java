package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookingService {

    public Response createBooking() {

        Map<String, Object> booking = new HashMap<>();

        booking.put("firstname", "David");
        booking.put("lastname", "Torres");
        booking.put("totalprice", 150);
        booking.put("depositpaid", true);

        Map<String, String> dates = new HashMap<>();
        dates.put("checkin", "2026-08-10");
        dates.put("checkout", "2026-08-15");

        booking.put("bookingdates", dates);
        booking.put("additionalneeds", "Breakfast");

        return given()
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post("/booking")
                .then()
                .extract()
                .response();
    }

    public Response getBooking(int bookingId) {

        return given()
                .when()
                .get("/booking/" + bookingId)
                .then()
                .extract()
                .response();

    }

    public Response updateBooking(int bookingId, String token) {

        Map<String, Object> booking = new HashMap<>();

        booking.put("firstname", "David Actualizado");
        booking.put("lastname", "Torres");
        booking.put("totalprice", 200);
        booking.put("depositpaid", true);

        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2026-08-20");
        bookingDates.put("checkout", "2026-08-25");

        booking.put("bookingdates", bookingDates);
        booking.put("additionalneeds", "Dinner");

        return given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .body(booking)
                .when()
                .put("/booking/" + bookingId)
                .then()
                .extract()
                .response();
    }
}