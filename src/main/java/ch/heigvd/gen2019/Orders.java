package ch.heigvd.gen2019;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orders = new ArrayList<Order>();

    public void AddOrder(Order order) {

        orders.add(order);
    }

    public int getOrdersCount() {

        return orders.size();
    }

    public Order getOrder(int i) {

        return orders.get(i);
    }


    public void ordersToString(StringBuffer sb){

        for (int i = 0; i < this.getOrdersCount(); i++) {
            Order order = this.getOrder(i);

            order.orderToString(sb);
        }

        if (this.getOrdersCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

    }
}
