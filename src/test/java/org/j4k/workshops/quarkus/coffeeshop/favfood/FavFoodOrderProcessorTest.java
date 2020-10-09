package org.j4k.workshops.quarkus.coffeeshop.favfood;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.UUID;

import org.j4k.workshops.quarkus.coffeeshop.domain.LineItem;
import org.j4k.workshops.quarkus.coffeeshop.domain.OrderInCommand;
import org.j4k.workshops.quarkus.coffeeshop.favfood.domain.FavFoodLineItem;
import org.j4k.workshops.quarkus.coffeeshop.favfood.domain.FavFoodOrder;
import org.j4k.workshops.quarkus.coffeeshop.favfood.domain.FavFoodOrderHandler;
import org.junit.jupiter.api.Test;

public class FavFoodOrderProcessorTest {


    @Test
    public void testFavFoodOrder(){

        FavFoodOrder favFoodOrder = new FavFoodOrder();
        favFoodOrder.setCustomerName("Lemmy");
        FavFoodLineItem favFoodLineItem = new FavFoodLineItem();
        favFoodLineItem.setItem("COFFEE_BLACK");
        favFoodLineItem.setItemId(UUID.randomUUID().toString());
        favFoodLineItem.setQuantity(1);
        favFoodOrder.setLineItems(Arrays.asList(favFoodLineItem));
        OrderInCommand expectedOrderInCommand = new OrderInCommand();
        expectedOrderInCommand.addBeverage(new LineItem("COFFEE_BLACK", "Lemmy"));

        OrderInCommand resultingOrderInCommand = FavFoodOrderHandler.createFromFavFoodOrder(favFoodOrder);

        assertEquals(expectedOrderInCommand.getBeverages().size(), resultingOrderInCommand.getBeverages().size());
        assertEquals(expectedOrderInCommand.getBeverages().get(0).getName(), resultingOrderInCommand.getBeverages().get(0).getName());
        assertEquals(expectedOrderInCommand.getBeverages().get(0).getItem(), resultingOrderInCommand.getBeverages().get(0).getItem());

    }
}