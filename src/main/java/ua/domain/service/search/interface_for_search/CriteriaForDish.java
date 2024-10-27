package ua.domain.service.search.interface_for_search;

import ua.domain.dish.Dish;

@FunctionalInterface
public interface CriteriaForDish<E extends Dish> {
    boolean match(E dish);
}
