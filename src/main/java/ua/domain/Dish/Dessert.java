package ua.domain.Dish;

public class Dessert extends Dish {

    private int weight;

    public Dessert(int id, double prize, String name, int weight, boolean vegeterian) {
        super(id, prize, name, vegeterian);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() +
                "weight=" + weight +
                '}';
    }
}
