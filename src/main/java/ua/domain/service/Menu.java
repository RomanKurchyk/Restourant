package ua.domain.service;

import ua.domain.dish.Dish;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private static List<Dish> dishes = new ArrayList<>();
    private static Menu menu;

    private Menu() {
    }

    List<Dish> getListFromMenu() {
        return dishes;
    }

    public static synchronized Menu getMenu() {
        if (menu == null) menu = new Menu();
        return menu;
    }

    public static synchronized void setMenu(List<Dish> newMenu) {
        dishes = newMenu;
    }

    public boolean addDish(Dish dish) throws WorkExeption {
        try {
            dishes.add(dish);
        } catch (Exception e) {
            throw new WorkExeption("Didn't add", e);
        }
        return true;
    }

    public boolean deleteDish(Dish dish) {
        try {
            dishes.remove(dish);

        } catch (Exception e) {
            throw new WorkExeption("Didn't delete", e);
        }
        return true;
    }

    public boolean isContainDish(int id) {
        for (Dish dish : dishes) {
            if (dish.getId() == id) return true;
        }
        return false;
    }

    public Dish getDish(int id) throws WorkExeption {
        for (Dish dish : dishes) {
            if (dish.getId() == id) return dish;
        }
        throw new WorkExeption("Not found");
    }

    @Override
    public String toString() {
        System.out.println("Menu:");
        for (Dish dish : dishes
        ) {
            System.out.println(dish.getId() + ". " + dish);
        }
        return "";
    }
}
