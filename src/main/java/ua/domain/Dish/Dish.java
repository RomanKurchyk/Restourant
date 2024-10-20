package ua.domain.Dish;

import ua.domain.Api.DishApi;

public class Dish implements DishApi {

    protected Dish(int id, double prize, String name, boolean vegeterian) {
        this.price = prize;
        this.name = name;
        this.vegeterian = vegeterian;
        this.id = id;
    }

    private String description;
    private final int id;
    private double price;
    private String name;
    private boolean vegeterian;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isVegeterian() {
        return vegeterian;
    }

    @Override
    public void setVegeterian(boolean vegeterian) {
        this.vegeterian = vegeterian;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", prize=" + price +
                ", name='" + name + '\'' +
                ", vegeterian=" + vegeterian + " ";
    }

}
