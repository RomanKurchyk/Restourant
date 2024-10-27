package ua.domain.dish;

import lombok.Getter;
import lombok.ToString;
import ua.domain.service.WorkException;

@ToString(callSuper = true)
@Getter

public class Dessert extends Dish {

    private int weight;

    public Dessert(int id, double price, String name, int weight, boolean vegetarian) throws WorkException {
        super(id, price, name, vegetarian);
        if (weight <= 0) throw new WorkException("Enter the correct weight");
        this.weight = weight;
    }

    public void setWeight(int weight) throws WorkException {
        if (weight <= 0) throw new WorkException("Enter the correct weight");
        this.weight = weight;
    }

}
