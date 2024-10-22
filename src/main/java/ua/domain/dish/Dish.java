package ua.domain.dish;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.domain.api.Identifier;
import ua.domain.api.Vegetarian;
import ua.domain.service.WorkExeption;

@ToString
@Getter
@Setter

public class Dish implements Vegetarian, Identifier {

    private String description;
    private final int id;
    private double price;
    private String name;
    private boolean isVegetarian;

    protected Dish(int id, double prize, String name, boolean isVegetarian) {
        if (id <= 0 || prize <= 0) throw new WorkExeption("Enter the correct data");
        this.price = prize;
        this.name = name;
        this.isVegetarian = isVegetarian;
        this.id = id;
    }

    public void setPrice(double price) throws WorkExeption {
        if (price <= 0) throw new WorkExeption("Enter the correct price");
        this.price = price;
    }

}
