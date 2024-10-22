package ua.domain.dish;


import lombok.ToString;

@ToString(callSuper = true)

public class MainCourse extends Dish {

    public MainCourse(int id, double prize, String name, boolean vegeterian) {
        super(id, prize, name, vegeterian);
    }


 }
