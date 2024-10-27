package ua.domain.service;

import ua.domain.dish.Dish;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private static List<Dish> dishes = new ArrayList<>(100);
    private static Menu menu;

    private Menu() {
    }

    public static synchronized List<Dish> getListFromMenu() {
        return dishes;
    }

    public static synchronized Menu getMenu() {
        if (menu == null) menu = new Menu();
        return menu;
    }

    public static synchronized void setMenu(List<Dish> newMenu) {
        dishes = newMenu;
    }

    public boolean addDish(Dish dish) throws WorkException {
        if(dish==null||isContainDish(dish.getId())||isContainDish(dish.getName())) throw new WorkException("Can't added");
        try {
            dishes.add(dish);
        } catch (Exception e) {
            throw new WorkException("Didn't add", e);
        }
        return true;
    }

    public boolean deleteDish(Dish dish) {
        try {
            dishes.remove(dish);

        } catch (Exception e) {
            throw new WorkException("Didn't delete", e);
        }
        return true;
    }

    public boolean isContainDish(int id) {
        for (Dish dish : dishes) {
            if (dish.getId() == id) return true;
        }
        return false;
    }

    public boolean isContainDish(String name) {
        for (Dish dish : dishes) {
            if (dish.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public Dish getDish(int id) throws WorkException {
        for (Dish dish : dishes) {
            if (dish.getId() == id) return dish;
        }
        throw new WorkException("Not found");
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
