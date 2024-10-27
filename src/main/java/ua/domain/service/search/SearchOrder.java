package ua.domain.service.search;

import lombok.Getter;
import ua.domain.enum_for_dish.OrderStatus;
import ua.domain.service.Order;
import ua.domain.service.WorkException;
import ua.domain.service.search.interface_for_search.CriteriaForOrder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
public class SearchOrder extends Search<Order> {


    private List<Order> filterOrders(List<Order> orders, CriteriaForOrder criteria) throws WorkException {
        if (orders == null) throw DATA_EXCEPTION;

        List<Order> filteredOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order != null && criteria.match(order)) {
                filteredOrders.add(order);
            }
        }
        if (filteredOrders.isEmpty()) throw FOUND_EXCEPTION;
        return filteredOrders;
    }
//for understanding
    public List<Order> searchByDate(List<Order> orders, LocalDate date) throws WorkException {
        return filterOrders(orders, new CriteriaForOrder() {
            @Override
            public boolean match(Order order) {
                return order.getCreated().toLocalDate().isEqual(date);
            }

        });
    }

    public List<Order> searchByTable(List<Order> orders, int numberOfTable) throws WorkException {
        return filterOrders(orders, order -> order.getNumberOfTable() == numberOfTable);
    }

    public List<Order> searchByStatus(List<Order> orders, OrderStatus status) throws WorkException {
        return filterOrders(orders, order -> order.getStatus().equals(status));
    }

    public List<Order> searchByPrice(List<Order> orders, double price) throws WorkException {
        return filterOrders(orders, order -> Double.compare(order.getPrice(), price) == 0);
    }


}
