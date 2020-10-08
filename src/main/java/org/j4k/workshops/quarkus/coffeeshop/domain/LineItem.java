package org.j4k.workshops.quarkus.coffeeshop.domain;

import java.util.Objects;
import java.util.StringJoiner;

public class LineItem {

    String item;

    String itemId;

    int quantity;

    public LineItem() {
    }

    public LineItem(String item, String itemId, int quantity) {
        this.item = item;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LineItem.class.getSimpleName() + "[", "]")
                .add("item='" + item + "'")
                .add("itemId='" + itemId + "'")
                .add("quantity=" + quantity)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return quantity == lineItem.quantity &&
                Objects.equals(item, lineItem.item) &&
                Objects.equals(itemId, lineItem.itemId);
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
