package restaurantsim.managers;

import restaurantsim.models.Food;
import restaurantsim.models.Person;
import restaurantsim.models.Restaurant;

import java.util.ArrayList;
import java.util.Arrays;

public class VariableManager {
    private final static Restaurant[] restaurants = {
            new Restaurant("McDonalds", new ArrayList<Food>(Arrays.asList(
                    new Food("Hamburger", 10.00),
                    new Food("Cheeseburger", 20.00),
                    new Food("Chicken Nuggets", 25.00),
                    new Food("French Fries", 10.00),
                    new Food("Soda", 15.00)
            ))),
            new Restaurant("KFC", new ArrayList<Food>(Arrays.asList(
                    new Food("Original Recipe Chicken", 30.00),
                    new Food("Hot Wings", 25.00),
                    new Food("Coleslaw", 15.00),
                    new Food("French Fries", 12.00),
                    new Food("Soda", 15.00)
            ))),
            new Restaurant("Chop Chop", new ArrayList<Food>(Arrays.asList(
                    new Food("Beef with Bamboo Shoots", 42.00),
                    new Food("Vegetarian Wok", 35.00),
                    new Food("Fried Rice", 20.00),
                    new Food("Spring Rolls", 18.00),
                    new Food("Soda", 15.00)
            ))),
            new Restaurant("Pizza Hut", new ArrayList<Food>(Arrays.asList(
                    new Food("Pepperoni Lovers Pizza", 65.00),
                    new Food("Margherita", 55.00),
                    new Food("Breadsticks", 25.00),
                    new Food("Garlic Dip", 10.00),
                    new Food("Soda", 15.00)
            ))),
            new Restaurant("Sushi Yama", new ArrayList<Food>(Arrays.asList(
                    new Food("Salmon Nigiri", 18.00),
                    new Food("Tempura Roll", 28.00),
                    new Food("Miso Soup", 12.00),
                    new Food("Edamame Beans", 15.00),
                    new Food("Green Tea", 10.00)
            )))
    };
    private final static ArrayList<Person> persons = new ArrayList<Person>();
    private static Person currentSelectedPerson;
    private static Restaurant currentSelectedRestaurant;
    private final static ArrayList<Food> orderedFoodItems = new ArrayList<Food>();
    private static double orderedFoodCost = 0;

    public static Restaurant[] getRestaurants() {
        return restaurants;
    }

    public static ArrayList<Person> getPersons() {
        return persons;
    }

    public static Person getCurrentSelectedPerson() {
        return currentSelectedPerson;
    }

    public static void setCurrentSelectedPerson(Person currentSelectedPerson) {
        VariableManager.currentSelectedPerson = currentSelectedPerson;
    }

    public static Restaurant getCurrentSelectedRestaurant() {
        return currentSelectedRestaurant;
    }

    public static void setCurrentSelectedRestaurant(Restaurant currentSelectedRestaurant) {
        VariableManager.currentSelectedRestaurant = currentSelectedRestaurant;
    }

    public static ArrayList<Food> getOrderedFoodItems() {
        return orderedFoodItems;
    }

    public static double getOrderedFoodItemsCost() {
        return orderedFoodCost;
    }

    public static void setOrderedFoodItemsCost(double orderedFoodCost) {
        VariableManager.orderedFoodCost += orderedFoodCost;
    }

    public static void setOrderedFoodItemsCostToZero() {
        VariableManager.orderedFoodCost = 0;
    }
}
