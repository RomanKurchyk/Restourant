package ua.domain.Dish;

import ua.domain.Enum.DrinkSize;
import ua.domain.Service.WorkExeption;

public class Drink extends Dish {

    private DrinkSize drinkSize;
    private int volume;

    public Drink(int id, double price, String name, boolean vegeterian, DrinkSize drinkSize, int volume) throws WorkExeption {
        super(id, price * drinkSize.getCoof(), name, vegeterian);
        if (volume <= 0) throw new WorkExeption("Enter the correct volume");
        this.drinkSize = drinkSize;
        this.volume = volume;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    public int getVolume() {
        return volume;
    }

    public void setDrinkSize(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }

    public void setVolume(int volume) throws WorkExeption {
        if (volume <= 0) throw new WorkExeption("Enter the correct weight");
        this.volume = volume;
    }

    @Override
    public String toString() {

        return super.toString() +
                "drinkSize=" + drinkSize +
                ", volume=" + volume +
                '}';
    }
}
