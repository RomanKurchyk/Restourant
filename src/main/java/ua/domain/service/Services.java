package ua.domain.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ua.domain.dish.Dish;
import ua.domain.enum_for_dish.OrderStatus;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PACKAGE)

public class Services {

    private static final Orders ORDERS = Orders.getOrders();
    private static final Menu MENU = Menu.getMenu();

    public Order createOrder(int numberOfTable) throws WorkExeption {
        if (numberOfTable < 1) throw new WorkExeption("Send right number of table");
        int orderId = ORDERS.getNumberOfOrders() + 1;
        Order order = new Order(numberOfTable, orderId);
        if (ORDERS.add(order)) return order;
        else throw new WorkExeption("Order not created");
    }

    public List<Order> activeByTable(int numberOfTable) throws WorkExeption {
        if (numberOfTable < 1) throw new WorkExeption("Send right number of table");
        List<Order> orders = ORDERS.getOrderList();
        for (Order order : orders
        ) {
            if (order.getNumberOfTable() == numberOfTable && order.getStatus() != OrderStatus.PAID) orders.add(order);
        }
        if (orders.isEmpty()) throw new WorkExeption("Orders not found");
        return orders;
    }

    public List<Dish> getVegetarianList() throws WorkExeption {
        List<Dish> dishes = MENU.getListFromMenu();
        dishes.removeIf(dish -> !dish.isVegetarian());
        if (dishes.isEmpty()) throw new WorkExeption("Vegeterian dish is not found");
        return dishes;
    }

}
