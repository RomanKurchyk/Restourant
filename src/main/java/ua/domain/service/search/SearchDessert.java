package ua.domain.service.search;


import ua.domain.dish.Dessert;
import ua.domain.service.WorkException;
import java.util.List;

public class SearchDessert extends SearchDish<Dessert> {

    public List<Dessert> searchByVolume(List<Dessert> desserts, int weight) throws WorkException {
        return filterDish(desserts, dessert -> {
            if (dessert instanceof Dessert) {
                return ((Dessert) dessert).getWeight() == weight;
            }
            return false;
        });
    }

}
