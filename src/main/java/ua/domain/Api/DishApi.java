package ua.domain.Api;

import ua.domain.Service.WorkExeption;

public interface DishApi extends Identifier {

    boolean isVegeterian();

    void setVegeterian(boolean vegeterian);

    String getDescription();

    void setDescription(String description);

    double getPrice();

    void setPrice(double price) throws WorkExeption;

    String getName();

    void setName(String name);
}
