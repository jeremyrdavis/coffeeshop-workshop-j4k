package org.j4k.workshops.quarkus.coffeeshop.favfood.domain;

import java.util.Objects;
import java.util.StringJoiner;

public class FavFoodLineItem {

    String item;

    String itemId;

    int quantity;

    @Override
    public String toString() {
        return new StringJoiner(", ", FavFoodLineItem.class.getSimpleName() + "[", "]")
                .add("item='" + item + "'")
                .add("itemId='" + itemId + "'")
                .add("quantity=" + quantity)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavFoodLineItem favFoodLineItem = (FavFoodLineItem) o;
        return quantity == favFoodLineItem.quantity &&
                Objects.equals(item, favFoodLineItem.item) &&
                Objects.equals(itemId, favFoodLineItem.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, itemId, quantity);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
