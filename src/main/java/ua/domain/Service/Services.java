package ua.domain.Service;

import ua.domain.Enum.OrderStatus;
import ua.domain.Api.DishApi;
import java.util.List;
import java.util.Set;

public class Services {

    private static final Orders ORDERS = Orders.getOrders();
    private static final Menu MENU = Menu.getMenu();

    Services() {
    }

    public Order createOrder(int numberOfTable) throws WorkExeption {
        if (numberOfTable < 1) throw new WorkExeption("Send right number of table");
        int orderId = ORDERS.getNumberOfOrders() + 1;
        Order order = new Order(numberOfTable, orderId);
        if (ORDERS.add(order)) return order;
        else throw new WorkExeption("Order not created");
    }

    public List<Order> ActiveByTable(int numberOfTable) throws WorkExeption {
        if (numberOfTable < 1) throw new WorkExeption("Send right number of table");
        List<Order> orders = ORDERS.getOrderList();
        for (Order order : orders
        ) {
            if (order.getNumberOfTable() == numberOfTable && order.getStatus() != OrderStatus.PAID) orders.add(order);
        }
        if (orders.isEmpty()) throw new WorkExeption("Orders not found");
        return orders;
    }

    public Set<DishApi> vegeterianList() throws WorkExeption {
        Set<DishApi> dishes = MENU.getListFromMenu();
        dishes.removeIf(dish -> !dish.isVegeterian());
        if (dishes.isEmpty()) throw new WorkExeption("Vegeterian dish is not found");
        return dishes;
    }

    public List<Order> getOrderList() {
        return ORDERS.getOrderList();

    }
}
