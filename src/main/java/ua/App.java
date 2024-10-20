package ua;

import ua.domain.Dish.Dessert;
import ua.domain.Dish.Drink;
import ua.domain.Dish.MainCourse;
import ua.domain.Enum.DrinkSize;
import ua.domain.Api.DishApi;
import ua.domain.Service.*;
import java.util.List;
import static ua.domain.Enum.OrderStatus.PAID;

public class App {

    public static  void main(String[] args) {

        User user = new User(1, "Name", "password");
        DishApi one  = new Dessert(1, 5, "meal", 200,true);
        DishApi two = new MainCourse(2, 5, "bread", true);
        DishApi three = new Drink(3, 15, "milk", true, DrinkSize.LARGE, 100);
        Menu menu = Menu.getMenu();
        menu.getListFromMenu().add(two);
        menu.getListFromMenu().add(one);
        menu.getListFromMenu().add(three);
        System.out.println(menu.isDish(1));
        System.out.println(menu.getListFromMenu());
        System.out.println();
        Services services = user.createService();
        Order order1 = services.createOrder(6);
        Order order2 = services.createOrder(5);
        System.out.println(order2);
        System.out.println(order1.getCreated());
        order1.setStatus(PAID);
        order1.addDish(one, 2);
        order1.addDish(two, 1);
        order1.addDish(three, 5);
        List<Order> orders = services.getOrderList();
        for (Order order : orders) {
            System.out.println(order.toString());
                    }
        services.createOrder(10);
    }


}
