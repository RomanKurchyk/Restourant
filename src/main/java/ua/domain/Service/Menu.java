package ua.domain.Service;

import ua.domain.Api.DishApi;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private static List<DishApi> dishList = new ArrayList<>();
    private static final Menu MENU = new Menu();

    private Menu() {

    }

    public static Menu getMenu() {
        return MENU;
    }

    public static void setMenu(List<DishApi> newMenu) {
        dishList = newMenu;
    }

    public List<DishApi> getListFromMenu() {
        return dishList;
    }

    public boolean addDish(DishApi dish) {
        return dishList.add(dish);
    }

    public boolean deleteDish(DishApi dish) {
        return dishList.remove(dish);
    }

    public boolean isDish(int id) {
        for (DishApi dish : dishList) {
            if (dish.getId() == id) return true;
        }
        return false;
    }

    public DishApi getDish(int id) {
        for (DishApi dish : dishList) {
            if (dish.getId() == id) return dish;
        }
        System.out.println("Not found");
        return null;
    }

}
