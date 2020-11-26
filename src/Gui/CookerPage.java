package Gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Data.ReservedTables;
import Data.Restaurant;
import Functions.Verification;

import javax.xml.bind.JAXBException;
import java.util.List;


public class CookerPage {

    Stage stage ;
    Loginform loginform;
    Scene scene ;
    Verification verification = new Verification();
    CookerPage cookerPage;


    public CookerPage(Stage stage){
        this.stage=stage;
    }

    public void Scene2()
    {

        Label welcome = new Label("Orders ");
        Button logout = new Button("Logout");
        Button orders = new Button("View Orders");
        Button clear = new Button("Clear");
        orders.setDisable(true);
        ChoiceBox<String> time = new ChoiceBox<>() ;
        time.getItems().addAll("6","7","8","9","10","11","12","1","2");
        Label pm = new Label();
        Label suitable = new Label("Please choose a suitable time:");
        time.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (time.getValue().equals("12") || time.getValue().equals("1") || time.getValue().equals("2") ){
                    pm.setText(":00  am");
                    orders.setDisable(false);
                }
                else
                {
                    pm.setText(":00 pm");
                    orders.setDisable(false);
                }
            }
        });



        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(4);
        grid.add(welcome,0,0);
        grid.add(suitable,0,2);
        grid.add(time,2,2);
        grid.add(pm,3,2);
        grid.add(logout,0,50);
        grid.add(orders,0,45);
        grid.add(clear,2,45);
        scene = new Scene(grid,800,1000);




        orders.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Restaurant restaurant = null;
                try {
                    restaurant = verification.load2();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                List<ReservedTables> tables = restaurant.getTables().getReservedTables();
                Label tableNumber = new Label("Table Number");
                tableNumber.setFont(Font.font(16));
                Label order = new Label("Order");
                order.setFont(Font.font(16));
                Label quantity = new Label("Quantity");
                quantity.setFont(Font.font(16));
                Label no = new Label();

                grid.add(tableNumber,0,4) ;
                grid.add(order,4,4) ;
                grid.add(quantity,8,4);

                int i;
                int x;
                x=6;
                int count=0;
                for (i=0 ;i<tables.size();i++){
                    if(tables.get(i).getTime().equals(time.getValue()))
                    {
                        count++;
                        Label salade = new Label();
                        Label fries = new Label();
                        Label chicken = new Label();
                        Label soup = new Label();
                        Label beef = new Label();
                        Label molten = new Label();
                        Label apple = new Label();
                        Label tableNumber1 = new Label();
                        tableNumber1.setFont(Font.font(16));
                        Label chickenQuant = new Label();
                        Label soupQuant = new Label();
                        Label beefQuant = new Label();
                        Label friesQuant = new Label();
                        Label saladeQuant = new Label();
                        Label moltenQuant = new Label();
                        Label appleQuant = new Label();
                        tableNumber1.setText(tables.get(i).getNumber());
                        grid.add(tableNumber1,0,x);
                    if (tables.get(i).getGrilled()!=0){
                        chicken.setText("Grilled Chicken");
                        chicken.setFont(Font.font(14));
                        chickenQuant.setText("X" + String.valueOf(tables.get(i).getGrilled()));
                        grid.add(chickenQuant,8,x);
                        grid.add(chicken,4,x);
                        x++;
                    }
                    if (tables.get(i).getSoup()!=0){
                        soup.setText("Mushroom Soup");
                        soup.setFont(Font.font(14));
                        soupQuant.setText("X" + String.valueOf(tables.get(i).getSoup()));
                        grid.add(soupQuant,8,x);
                        grid.add(soup,4,x);
                        x++;
                    }
                    if (tables.get(i).getBeef()!=0){
                        beef.setText("Beef Steak");
                        beef.setFont(Font.font(14));
                        beefQuant.setText("X" + String.valueOf(tables.get(i).getBeef()));
                        grid.add(beefQuant,8,x);
                        grid.add(beef,4,x);
                        x++;
                    }
                    if (tables.get(i).getFries()!=0){
                        fries.setText("Fried Potatos");
                        fries.setFont(Font.font(14));
                        friesQuant.setText("X" + String.valueOf(tables.get(i).getFries()));
                        grid.add(friesQuant,8,x);
                        grid.add(fries,4,x);
                        x++;
                    }
                    if (tables.get(i).getSalade()!=0){
                        salade.setText("Greek Salade");
                        salade.setFont(Font.font(14));
                        saladeQuant.setText("X" + String.valueOf(tables.get(i).getSalade()));
                        grid.add(saladeQuant,8,x);
                        grid.add(salade,4,x);
                        x++;
                    }
                    if (tables.get(i).getMolten()!=0){
                        molten.setText("Molten Cake");
                        molten.setFont(Font.font(14));
                        moltenQuant.setText("X" + String.valueOf(tables.get(i).getMolten()));
                        grid.add(moltenQuant,8,x);
                        grid.add(molten,4,x);
                        x++;
                    }
                    if (tables.get(i).getApple()!=0)
                    {
                        apple.setText("Apple Pie");
                        apple.setFont(Font.font(14));
                        appleQuant.setText("X" + String.valueOf(tables.get(i).getApple()));
                        grid.add(appleQuant,8,x);
                        grid.add(apple,4,x);
                        x++;
                    }
                    }
                }
                if (count==0){
                    no.setText("There are no Orders for this hour");
                    grid.add(no,2,6);
                }
            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cookerPage.Scene2();
                stage.setScene(cookerPage.getScene());
            }
        });

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginform.LoginScreen();
                stage.setScene(loginform.getScene());

            }
        });

    }

    public Scene getScene() {
        return scene;
    }

    public void setLoginform(Loginform loginform) {
        this.loginform = loginform;
    }

    public void setCookerPage(CookerPage cookerPage) {
        this.cookerPage = cookerPage;
    }
}
