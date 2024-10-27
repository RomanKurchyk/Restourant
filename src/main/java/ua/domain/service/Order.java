package ua.domain.service;

import lombok.Getter;
import lombok.Setter;
import ua.domain.api.Identifier;
import ua.domain.dish.Dish;
import ua.domain.enum_for_dish.OrderStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter

public class Order implements Identifier {

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

    public void setNumberOfTable(int numberOfTable) throws WorkException {

        if (numberOfTable < 1) throw new WorkException("Send right number of table");
        else
            this.numberOfTable = numberOfTable;
    }

    public double addDish(Dish dish, int numberOfDishes) throws WorkException {
        Menu menu = Menu.getMenu();
        if (menu.isContainDish(dish.getId())) {
            try {
                orderList.add(dish);
            } catch (Exception e) {
                throw new WorkException("Dish didn't add", e);
            }
            price = price + dish.getPrice() * numberOfDishes;
        } else throw new WorkException("Dish is not found in menu");
        return price;
    }

    public double deleteDish(Dish dish, int numberOfDishes) throws WorkException {

        if (numberOfDishes * dish.getPrice() < 0) return -1;
        try {
            orderList.remove(dish.getId());
        } catch (Exception e) {
            throw new WorkException("Dish didn't add", e);
        }
        price = price - dish.getPrice() * numberOfDishes;
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id = " + id +
                ", numberOfTable = " + numberOfTable +
                ", dishes = " + orderList +
                ", status = " + status +
                ", orderPrize = " + price +
                ", created = " + DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm").format(created) +
                '}';
    }

}
