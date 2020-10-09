package org.j4k.workshops.quarkus.coffeeshop.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class OrderInCommand {

    String id;

    List<LineItem> beverages;

    List<LineItem> kitchenOrders;

    /**
     *
     */
    public OrderInCommand() {
    }

    public void addBeverage(LineItem lineItem){
        if(this.beverages == null) this.beverages = new ArrayList<LineItem>();
        this.beverages.add(lineItem);
    }

    public void addKitchenOrder(LineItem lineItem){
        if(this.kitchenOrders == null) this.kitchenOrders = new ArrayList<LineItem>();
        this.kitchenOrders.add(lineItem);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((beverages == null) ? 0 : beverages.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((kitchenOrders == null) ? 0 : kitchenOrders.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderInCommand other = (OrderInCommand) obj;
        if (beverages == null) {
            if (other.beverages != null)
                return false;
        } else if (!beverages.equals(other.beverages))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (kitchenOrders == null) {
            if (other.kitchenOrders != null)
                return false;
        } else if (!kitchenOrders.equals(other.kitchenOrders))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "OrderInCommand [beverages=" + beverages + ", id=" + id + ", kitchenOrders=" + kitchenOrders + "]";
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the beverages
     */
    public List<LineItem> getBeverages() {
        return beverages;
    }

    /**
     * @param beverages the beverages to set
     */
    public void setBeverages(List<LineItem> beverages) {
        this.beverages = beverages;
    }

    /**
     * @return the kitchenOrders
     */
    public List<LineItem> getKitchenOrders() {
        return kitchenOrders;
    }

    /**
     * @param kitchenOrders the kitchenOrders to set
     */
    public void setKitchenOrders(List<LineItem> kitchenOrders) {
        this.kitchenOrders = kitchenOrders;
    }


}