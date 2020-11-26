package Functions;

import Data.Dish;
import Data.Dishes;
import Data.Restaurant;
import javafx.collections.ObservableList;
import sun.applet.Main;

import javax.xml.bind.JAXBException;
import java.util.List;

public class Calculations {

    private double salad;
    private double fries;
    private double chick;
    private double soup;
    private double beef;
    private double molten;
    private double apple;


    private double totalprice;

    public double getTotalprice() {
        total();
        return totalprice;
    }

    Verification verification = new Verification();
    public void total(){

        totalprice= salad + fries + chick + soup + beef + molten + apple ;
    }

    public double calculate(String Name , int Quantity) throws JAXBException {

        Restaurant restaurant =verification.load();
        List<Dish> dishes =restaurant.getDishes().getDishes();


        for (int i=0 ; i<dishes.size();i++) {
            if (dishes.get(i).getName().equals(Name) && dishes.get(i).getType().equals("appetizer")) {
                if (dishes.get(i).getName().equals("Greek Salade")) {
                    float Appetizer = (float) (Integer.parseInt(dishes.get(i).getPrice()) * Quantity * 1.10);
                    salad = Appetizer;
                    return Appetizer;
                }else if (dishes.get(i).getName().equals("Fried Potatos"))
                {
                    float Appetizer = (float) (Integer.parseInt(dishes.get(i).getPrice()) * Quantity * 1.10);
                    fries = Appetizer;
                    return Appetizer;
                }
            } else if (dishes.get(i).getName().equals(Name)&& dishes.get(i).getType().equals("main_course")) {
                if (dishes.get(i).getName().equals("Grilled Chicken")) {
                    float Main = (float) (Integer.parseInt(dishes.get(i).getPrice()) * Quantity * 1.10);
                    chick = Main;
                    return Main;
                }else if (dishes.get(i).getName().equals("Mushroom Soup"))
                {
                    double Main = (double) (Integer.parseInt(dishes.get(i).getPrice()) * Quantity * 1.15);
                    soup = Main;
                    return Main;
                }else if (dishes.get(i).getName().equals("Beef Steak"))
                {
                    double Main = (double) (Integer.parseInt(dishes.get(i).getPrice()) * Quantity * 1.15);
                    beef = Main;
                    return Main;
                }

            } else if (dishes.get(i).getName().equals(Name)&& dishes.get(i).getType().equals("desert") ) {
                if (dishes.get(i).getName().equals("Molten Cake")) {
                    double Desert = (double) (Integer.parseInt(dishes.get(i).getPrice()) * Quantity * 1.20);
                    molten = Desert;
                    return Desert;
                }else if (dishes.get(i).getName().equals("Apple Pie"))
                {
                    double Desert = (double) (Integer.parseInt(dishes.get(i).getPrice()) * Quantity * 1.20);
                    apple = Desert;
                    return Desert;

                }

            }
        }
        return 0 ;
    }


}
