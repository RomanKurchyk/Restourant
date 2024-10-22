package ua;

import ua.domain.dish.Dessert;
import ua.domain.dish.Dish;
import ua.domain.dish.Drink;
import ua.domain.dish.MainCourse;
import ua.domain.enum_for_dish.DrinkSize;
import ua.domain.service.*;

import static ua.domain.enum_for_dish.OrderStatus.PAID;

public class App {

    public static  void main(String[] args) {

        User user = new User(1, "Name", "password");
        Dish one  = new Dessert(1, 5, "meal", 200,true);
        Dish two = new MainCourse(2, 5, "bread", true);
        Dish three = new Drink(3, 15, "milk", true, DrinkSize.LARGE, 100);
        Dish four = new Drink(4,15,"milk",true,DrinkSize.SMALL,100);
        Menu menu = Menu.getMenu();
        menu.addDish(two);
        menu.addDish(one);
        menu.addDish(three);
        menu.addDish(four);
        System.out.println(menu.isContainDish(1));
        System.out.println(menu);
        Services services = user.createService();
        Order order1 = services.createOrder(6);
        Order order2 = services.createOrder(5);
        System.out.println(order2);
        order1.setStatus(PAID);
        order1.addDish(one, 2);
        order1.addDish(two, 1);
        order1.addDish(three, 5);
        services.createOrder(10);
        Services services1 = user.createService();
        Order order3 = services1.createOrder(5);
        System.out.println(order3);
        System.out.println(Orders.getOrders());
    }
}
