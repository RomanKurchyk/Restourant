package ua.domain.dish;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.domain.api.Identifier;
import ua.domain.api.Vegetarian;
import ua.domain.service.WorkException;

@ToString
@Getter
@Setter


public class Dish implements Vegetarian, Identifier {

    private String description;
    private final int id;
    private double price;
    private String name;
    private boolean isVegetarian;

    protected Dish(int id, double price, String name, boolean isVegetarian) {
        if (id <= 0 || price <= 0) throw new WorkException("Enter the correct data");
        this.price = price;
        this.name = name;
        this.isVegetarian = isVegetarian;
        this.id = id;
    }

    public void setPrice(double price) throws WorkException {
        if (price <= 0) throw new WorkException("Enter the correct price");
        this.price = price;
    }

}
