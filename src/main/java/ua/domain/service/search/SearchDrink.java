package ua.domain.service.search;


import ua.domain.dish.Drink;
import ua.domain.enum_for_dish.DrinkSize;
import ua.domain.service.WorkException;

import java.util.List;

public class SearchDrink extends SearchDish<Drink> {

    public List<Drink> searchBySize(List<Drink> drinks, DrinkSize drinkSize) throws WorkException {
        return filterDish(drinks, drink -> ((Drink) drink).getDrinkSize().equals(drinkSize));
    }

    public List<Drink> searchByVolume(List<Drink> drinks, int volume) throws WorkException {
        return filterDish(drinks, drink -> ((Drink) drink).getVolume() == volume);
    }
}

