package org.j4k.workshops.quarkus.coffeeshop.favfood;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.j4k.workshops.quarkus.coffeeshop.infrastructure.KafkaTestResource;
import org.j4k.workshops.quarkus.coffeeshop.infrastructure.RESTService;
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

@QuarkusTest @QuarkusTestResource(KafkaTestResource.class)
public class FavFoodOrderTest {

    Logger logger = LoggerFactory.getLogger(FavFoodOrderTest.class);

    final String json = "{\"customerName\":\"Lemmy\",\"orderId\":\"cdc07f8d-698e-43d9-8cd7-095dccace575\",\"lineItems\":[{\"item\":\"COFFEE_BLACK\",\"itemId\":\"0eb0f0e6-d071-464e-8624-23195c8f9e37\",\"quantity\":1}]}";

/*
    @InjectMock
    RESTService restService;
*/

    @Test
    public void testPlacingOrder() {

        JsonObject mockOrder = mockOrder();
        System.out.println(mockOrder);

        given()
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(json)
                .when()
                .post("/api/favfood")
                .then()
                    .statusCode(202)
                    .body("orderId", equalTo("cdc07f8d-698e-43d9-8cd7-095dccace575"))
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
                .add("item", "COFFEE_BLACK")
                .add("itemId", UUID.randomUUID().toString())
                .add("quantity", 1).build();
    }
}
