package ua.domain.dish;

import lombok.Getter;
import lombok.ToString;
import ua.domain.service.WorkExeption;

@ToString(callSuper = true)
@Getter()

public class Dessert extends Dish {

    private int weight;

    public Dessert(int id, double prize, String name, int weight, boolean vegeterian) throws WorkExeption {
        super(id, prize, name, vegeterian);
        if (weight <= 0) throw new WorkExeption("Enter the correct weight");
        this.weight = weight;
    }

    public void setWeight(int weight) throws WorkExeption {
        if (weight <= 0) throw new WorkExeption("Enter the correct weight");
        this.weight = weight;
    }

}
