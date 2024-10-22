package ua.domain.service;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private static final List<Order> ORDER_LIST = new ArrayList<>();
    private static int numberOfOrders = 0;
    private static Orders orders;

    private Orders() {
    }

    List<Order> getOrderList() {
        return ORDER_LIST;
    }

    public static synchronized Orders getOrders() {
        if (orders == null) orders = new Orders();
        return orders;
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

        if (orders.isOrder(order.getId())) throw new WorkExeption("The order has already been added ");
        try {
            ORDER_LIST.add(order);
        } catch (Exception e) {
            throw new WorkExeption("Order didn't add", e);
        }
        numberOfOrders++;
        return true;
    }

    @Override
    public String toString() {
        System.out.println("Orders:");
        for (Order order : ORDER_LIST
        ) {
            System.out.println(order.getId() + ". " + order);
        }
        return "";
    }
}
