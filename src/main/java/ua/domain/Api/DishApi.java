package ua.domain.Api;

public interface DishApi extends Identifier {

    boolean isVegeterian();

    void setVegeterian(boolean vegeterian);

    String getDescription();

    void setDescription(String description);

    double getPrice();

    void setPrice(double price);

    String getName();

    void setName(String name);
}
