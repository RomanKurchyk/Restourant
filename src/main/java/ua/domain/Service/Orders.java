package ua.domain.Service;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private static final List<Order> ORDER_LIST = new ArrayList<>();
    private static int numberOfOrders = 0;
    private static final Orders ORDERS = new Orders();

    private Orders() {
    }

    public static Orders getOrders() {
        return ORDERS;
    }

    public List<Order> getOrderList() {
        return ORDER_LIST;
    }

    public boolean isOrder(int id) {
        for (Order order : ORDER_LIST) {
            if (order.getId() == id) return true;
        }
        return false;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public synchronized boolean add(Order order) throws WorkExeption {

        if (ORDERS.isOrder(order.getId())) throw new WorkExeption("The order has already been added ");
        try {
            ORDER_LIST.add(order);
        } catch (Exception e) {
            throw new WorkExeption("Order didn't add", e);
        }
        numberOfOrders++;
        return true;
    }
}
