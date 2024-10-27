package ua.domain.service.search.interface_for_search;

import ua.domain.service.Order;
@FunctionalInterface
public interface CriteriaForOrder {
    boolean match(Order order);
}
