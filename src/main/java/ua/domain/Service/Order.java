package ua.domain.Service;

import ua.domain.Enum.OrderStatus;
import ua.domain.Api.DishApi;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order {

    private final int id;
    private int numberOfTable;
    private final Map<Integer, Double> orderList;
    private OrderStatus status;
    private double prize;
    private final LocalDateTime created;


     Order(int numberOfTable, int id) {
        this.id = id;
        this.numberOfTable = numberOfTable;
        this.orderList = new HashMap<>();
        this.status = OrderStatus.CREATED;
        this.prize = 0;
        this.created = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public int getNumberOfTable() {
        return numberOfTable;
    }

    public Map<Integer, Double> getOrderList() {
        return orderList;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getPrize() {
        return prize;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setNumberOfTable(int numberOfTable) {
        this.numberOfTable = numberOfTable;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double addDish(DishApi dish, int portion) {
        Menu menu = Menu.getMenu();
        if (menu.isDish(dish.getId())) {
            orderList.put(dish.getId(), dish.getPrice());
            prize = prize + dish.getPrice() * portion;
        } else System.out.println("Dish is not found in menu");
        return prize;
    }

    public double deleteDish(DishApi dish, int portion) {
        if(portion*dish.getPrice()==0) return -1;
        orderList.put(dish.getId(), dish.getPrice());
        prize = prize - dish.getPrice()* portion;
        return prize;
    }


    @Override
    public String toString() {
        return "Order{" +
                "numberOfTable=" + numberOfTable +
                ", dishes=" + orderList +
                ", status=" + status +
                ", orderPrize=" + prize +
                ", created=" + created +
                '}';
    }

}
