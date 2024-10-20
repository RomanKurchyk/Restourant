package ua.domain.Service;

import ua.domain.Api.DishApi;
import java.util.HashSet;
import java.util.Set;

public class Menu {

    private static Set<DishApi> dishList = new HashSet<>();
    private static final Menu MENU = new Menu();

    private Menu() {

    }

    public static Menu getMenu() {
        return MENU;
    }

    public static void setMenu(Set<DishApi> newMenu) {
        dishList = newMenu;
    }

    public Set<DishApi> getListFromMenu() {
        return dishList;
    }

    public boolean addDish(DishApi dish) throws WorkExeption{
        try {
            dishList.add(dish);
        } catch (Exception e) {
            throw new WorkExeption("Didn't add", e);
        }
        return true;
    }

    public boolean deleteDish(DishApi dish) {
        try {
            dishList.remove(dish);

        } catch (Exception e) {
            throw new WorkExeption("Didn't delete", e);
        }
        return true;
    }

    public boolean isDish(int id) {
        for (DishApi dish : dishList) {
            if (dish.getId() == id) return true;
        }
        return false;
    }

    public DishApi getDish(int id) throws WorkExeption {
        for (DishApi dish : dishList) {
            if (dish.getId() == id) return dish;
        }
        throw new WorkExeption("Not found");
    }

}
