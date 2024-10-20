package ua.domain.Service;

import ua.domain.Enum.OrderStatus;
import ua.domain.Api.DishApi;

import java.util.List;

public class Services {

    private static final Orders ORDERS = Orders.getOrders();
    private static final Menu MENU = Menu.getMenu();

    public Order createOrder(int numberOfTable) {
        int orderId = ORDERS.getNumberOfOrders() + 1;
        Order order = new Order(numberOfTable, orderId);
        if (ORDERS.add(order)) return order;
        else throw new WorkExeption("");

    }

    public List<Order> ActiveByTable(int numberOfTable) {
        List<Order> orders = ORDERS.getOrderList();
        for (Order order : orders
        ) {
            if (order.getNumberOfTable() == numberOfTable && order.getStatus() != OrderStatus.PAID) orders.add(order);
        }
        return orders;
    }

    public List<DishApi> vegeterianList() {
        List<DishApi> orders = MENU.getListFromMenu();
        for (DishApi dish : orders
        ) {
            if (!dish.isVegeterian()) {
                orders.remove(dish.getId());
            }

        }
        return orders;
    }

    public List<Order> getOrderList(){
        return ORDERS.getOrderList();

    }
}
