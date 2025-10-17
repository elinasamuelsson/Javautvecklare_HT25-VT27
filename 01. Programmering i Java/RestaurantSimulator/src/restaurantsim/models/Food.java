package restaurantsim.models;

public class Food {
    private String name;
    private double cost;

    public Food(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
