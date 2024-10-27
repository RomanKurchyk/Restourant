package ua.domain.service.search;

import ua.domain.dish.Dish;
import ua.domain.service.WorkException;
import ua.domain.service.search.interface_for_search.CriteriaForDish;

import java.util.ArrayList;
import java.util.List;

public class SearchDish<E extends Dish> extends Search<Dish> {

    protected List<E> filterDish(List<E> dishes, CriteriaForDish<Dish> criteria) throws WorkException {
        if (dishes == null) throw DATA_EXCEPTION;

        List<E> filteredDishes = new ArrayList<>();
        for (E dish : dishes) {
            if (dish != null && criteria.match(dish)) {
                filteredDishes.add(dish);
            }
        }
        if (filteredDishes.isEmpty()) throw FOUND_EXCEPTION;
        return filteredDishes;
    }

    public List<E> searchByName(List<E> dishes, String name) {
        return filterDish(dishes, dish -> dish.getName().equalsIgnoreCase(name));
    }

    public List<E> searchByPrice(List<E> dishes, double price) {
        return filterDish(dishes, dish -> Double.compare(dish.getPrice(), price) == 0);
    }

    public List<E> searchByVegetarian(List<E> dishes, boolean isVegeterian) {
        return filterDish(dishes, dish ->dish.isVegetarian()== isVegeterian);
    }


}
