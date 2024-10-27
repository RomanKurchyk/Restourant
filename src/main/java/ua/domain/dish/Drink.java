package ua.domain.dish;

import lombok.Getter;
import lombok.ToString;
import ua.domain.enum_for_dish.DrinkSize;
import ua.domain.service.WorkException;

@ToString(callSuper = true)
@Getter

public class Drink extends Dish {

    private DrinkSize drinkSize;
    private int volume;

    public Drink(int id, double price, String name, boolean vegeterian, DrinkSize drinkSize, int volume) throws WorkException {
        super(id, price * drinkSize.getCoof(), name, vegeterian);
        if (volume <= 0) throw new WorkException("Enter the correct volume");
        this.drinkSize = drinkSize;
        this.volume = volume;
    }

    public void setVolume(int volume) throws WorkException {
        if (volume <= 0) throw new WorkException("Enter the correct volume");
        this.volume = volume;
    }

}
