package ua.domain.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)

public class Services {

    private static final Orders ORDERS = Orders.getOrders();
    private static final Menu MENU = Menu.getMenu();

    public Order createOrder(int numberOfTable) throws WorkException {
        if (numberOfTable < 1) throw new WorkException("Send right number of table");
        int orderId = ORDERS.getNumberOfOrders() + 1;
        Order order = new Order(numberOfTable, orderId);
        if (ORDERS.add(order)) return order;
        else throw new WorkException("Order not created");
    }


}
