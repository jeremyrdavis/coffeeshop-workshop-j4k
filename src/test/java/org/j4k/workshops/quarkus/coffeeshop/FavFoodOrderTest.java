package org.j4k.workshops.quarkus.coffeeshop;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class FavFoodOrderTest {

    Logger logger = LoggerFactory.getLogger(FavFoodOrderTest.class);

    @Test
    public void testPlacingOrder() {

        JsonObject mockOrder = mockOrder();
        System.out.println(mockOrder);

        given()
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(mockOrder)
                .when()
                .post("/api/favfood")
                .then()
                    .statusCode(202)
                    .body("orderId", equalTo(mockOrder.getString("orderId")))
                    .body("customerName", equalTo("Lemmy"));

    }

    private JsonObject mockOrder() {

        return Json.createObjectBuilder()
                .add("customerName", "Lemmy")
                .add("orderId", UUID.randomUUID().toString())
                .add("lineItems", mockLineItems())
                .build();
    }

    private JsonArray mockLineItems() {

        final JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        jsonArrayBuilder.add(mockLineItem());
        return jsonArrayBuilder.build();
    }

    private JsonObject mockLineItem() {

        return Json.createObjectBuilder()
                .add("item", "BLACK_COFFEE")
                .add("itemId", UUID.randomUUID().toString())
                .add("quantity", 1).build();
    }
}
