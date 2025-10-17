package restaurantsim.models;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private ArrayList<Food> menu;

    public Restaurant(String name, ArrayList<Food> menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Food> getMenu() {
        return menu;
    }
}
