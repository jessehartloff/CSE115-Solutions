import java.util.ArrayList;
import java.util.HashMap;

public class Lab4 {


    static HashMap<String, Double> getMenu(){

        HashMap<String, Double> menu = new HashMap<>();

        menu.put("burger", 3.50);
        menu.put("fries", 1.50);
        menu.put("hot dog", 2.50);
        menu.put("soda", 1.00);
        menu.put("coffee", 1.75);
        menu.put("milkshake", 3.25);

        return menu;
    }


    static double getCost(ArrayList<String> order) {

        HashMap<String, Double> menu = getMenu();

        double orderCost = 0.0;
        for(String item : order){
            orderCost = orderCost + menu.get(item);
        }

        return orderCost;
    }


    public static void main(String[] args) {

        ArrayList<String> order1 = new ArrayList<>();
        order1.add("burger");
        order1.add("fries");
        order1.add("milkshake");

        ArrayList<String> order2 = new ArrayList<>();
        order2.add("coffee");

        double order1Cost = getCost(order1);
        double order2Cost = getCost(order2);

        System.out.println("Order1 costs $" + order1Cost);
        System.out.println("Order2 costs $" + order2Cost);

    }


}
