package ua.domain.dish;


import lombok.ToString;

@ToString(callSuper = true)

public class MainCourse extends Dish {

    public MainCourse(int id, double price, String name, boolean vegetarian) {
        super(id, price, name, vegetarian);
    }


 }
