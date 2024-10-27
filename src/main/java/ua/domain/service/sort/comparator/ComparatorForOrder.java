package ua.domain.service.sort.comparator;

import ua.domain.enum_for_dish.OrderStatus;
import ua.domain.service.Order;

import java.time.LocalDate;
import java.util.List;

public class ComparatorForOrder {
    List<Order> compareByDate(LocalDate date) {
        return null;
    }

    List<Order> comapreByTable(int numberOfTable) {
        return null;
    }

    List<Order> compareByTable(int numberOfTable, LocalDate date) {
        return null;
    }

    List<Order> compareByTable(int numberOfTable, OrderStatus status) {
        return null;
    }

    List<Order> compareByStatus(OrderStatus status) {
        return null;
    }

    List<Order> compareByPrice(double priece) {
        return null;
    }
}
