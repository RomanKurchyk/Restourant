package ua.domain.service;

import lombok.Getter;
import lombok.Setter;
import ua.domain.dish.Dish;
import ua.domain.enum_for_dish.OrderStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter

public class Order {

    private final int id;
    private int numberOfTable;
    private final List<Dish> orderList;
    private OrderStatus status;
    private double price;
    private final LocalDateTime created;

    Order(int numberOfTable, int id) {
        this.id = id;
        this.numberOfTable = numberOfTable;
        this.orderList = new ArrayList<>();
        this.status = OrderStatus.CREATED;
        this.price = 0;
        this.created = LocalDateTime.now();
    }

    public void setNumberOfTable(int numberOfTable) throws WorkExeption{

        if (numberOfTable < 1) throw new WorkExeption("Send right number of table");
        else
            this.numberOfTable = numberOfTable;
    }

    public double addDish(Dish dish, int numberOfDishes) throws WorkExeption {
        Menu menu = Menu.getMenu();
        if (menu.isContainDish(dish.getId())) {
            try {
                orderList.add(dish);
            } catch (Exception e) {
                throw new WorkExeption("Dish didn't add", e);
            }
            price = price + dish.getPrice() * numberOfDishes;
        } else throw new WorkExeption("Dish is not found in menu");
        return price;
    }

    public double deleteDish(Dish dish, int numberOfDishes) throws WorkExeption {

        if (numberOfDishes * dish.getPrice() < 0) return -1;
        try {
            orderList.remove(dish.getId());
        } catch (Exception e) {
            throw new WorkExeption("Dish didn't add", e);
        }
        price = price - dish.getPrice() * numberOfDishes;
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "numberOfTable = " + numberOfTable +
                ", dishes = " + orderList +
                ", status = " + status +
                ", orderPrize = " + price +
                ", created = " + DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm").format(created) +
                '}';
    }

}
