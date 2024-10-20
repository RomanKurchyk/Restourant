package ua.domain.Dish;

 public class MainCourse extends Dish {

    public MainCourse(int id, double prize, String name, boolean vegeterian) {
        super(id, prize, name, vegeterian);
    }

     @Override
     public String toString() {
         return  super.toString()+'}';
     }
 }
