package ua.domain.Dish;

import ua.domain.Enum.DrinkSize;

public class Drink extends Dish {

    private DrinkSize drinkSize;
    private int volume;

    public Drink(int id, double price, String name, boolean vegeterian, DrinkSize drinkSize, int volume) {
        super(id, price * drinkSize.getCoof(), name, vegeterian);
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

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {

        return  super.toString()+
                "drinkSize=" + drinkSize +
                ", volume=" + volume +
                '}';
    }
}
