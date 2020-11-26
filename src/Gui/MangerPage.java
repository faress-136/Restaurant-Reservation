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

public class MangerPage {
    Stage stage ;
    Loginform loginform;
    Scene scene ;
    Verification verification = new Verification();
    Next next;
    private  int index;
    private String times;
    MangerPage mangerPage;

    public String getTimes() {
        return times;
    }

    public int getIndex() {
        return index;
    }

    public MangerPage(Stage stage){
        this.stage=stage;
    }
    public void Scene2()
    {
        Label label = new Label("Restaurant");
        label.setFont(Font.font(20));
        Button logout = new Button("Logout");
        Button totalMoney = new Button("Show Total Money");
        Button view = new Button("View Reservations");
        Button nextPage = new Button("Next Page");
        Button clear = new Button("Clear");
        nextPage.setDisable(true);
        ChoiceBox<String> time = new ChoiceBox<>() ;
        time.getItems().addAll("6","7","8","9","10","11","12","1","2");
        Label pm = new Label();
        Label suitable = new Label("Please choose time:");
        time.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (time.getValue().equals("12") || time.getValue().equals("1") || time.getValue().equals("2") ){
                    pm.setText(":00  am");
                    view.setDisable(false);
                    times=time.getValue();
                }
                else {
                    pm.setText(":00 pm");
                    view.setDisable(false);
                    times=time.getValue();
                }

            }
        });


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(6);
        grid.add(label,0,0);
        grid.add(view,0,35);
        grid.add(suitable,0,2);
        grid.add(time,1,2);
        grid.add(pm,2,2);
        grid.add(totalMoney,2,35);
        grid.add(nextPage,4,35);
        grid.add(clear,3,35);
        grid.add(logout,0,40);

        view.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Restaurant restaurant = null;
                try {
                    restaurant = verification.load2();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                List<ReservedTables> tables = restaurant.getTables().getReservedTables();

                Label clientName = new Label("Client Name");
                clientName.setFont(Font.font(18));
                Label tableNumber = new Label("Table Number");
                tableNumber.setFont(Font.font(18));
                Label order = new Label("Order");
                order.setFont(Font.font(18));
                Label payment = new Label("Payment");
                payment.setFont(Font.font(18));
                Label quantity = new Label("Quantity");
                quantity.setFont(Font.font(18));
                Label no = new Label();

                grid.add(clientName, 0, 4);
                grid.add(tableNumber, 2, 4);
                grid.add(order, 4, 4);
                grid.add(payment, 8, 4);
                grid.add(quantity, 6, 4);

                int x = 6;
                int Count = 0;
                int i ;

                    for ( i = 0; i < tables.size(); i++) {
                        index = i ;
                        if (Count < 4) {
                            if (tables.get(i).getTime().equals(time.getValue())) {
                                Count++;
                                Label salade = new Label();
                                Label fries = new Label();
                                Label chicken = new Label();
                                Label soup = new Label();
                                Label beef = new Label();
                                Label molten = new Label();
                                Label apple = new Label();
                                Label clientName1 = new Label();
                                clientName1.setText(tables.get(i).getName().toUpperCase());
                                clientName1.setFont(Font.font(16));
                                Label tableNumber1 = new Label();
                                tableNumber1.setText(tables.get(i).getNumber());
                                tableNumber1.setFont(Font.font(16));
                                Label chickenQuant = new Label();
                                Label soupQuant = new Label();
                                Label beefQuant = new Label();
                                Label friesQuant = new Label();
                                Label saladeQuant = new Label();
                                Label moltenQuant = new Label();
                                Label appleQuant = new Label();
                                Label payment1 = new Label();
                                payment1.setText(String.valueOf(tables.get(i).getPaid()));
                                payment1.setFont(Font.font(16));
                                grid.add(payment1, 8, x);
                                grid.add(tableNumber1, 2, x);
                                grid.add(clientName1, 0, x);
                                if (tables.get(i).getGrilled() != 0) {
                                    chicken.setText("Grilled Chicken");
                                    chicken.setFont(Font.font(14));
                                    chickenQuant.setText("X" + String.valueOf(tables.get(i).getGrilled()));
                                    grid.add(chickenQuant, 6, x);
                                    grid.add(chicken, 4, x);
                                    x++;
                                }
                                if (tables.get(i).getSoup() != 0) {
                                    soup.setText("Mushroom Soup");
                                    soup.setFont(Font.font(14));
                                    soupQuant.setText("X" + String.valueOf(tables.get(i).getSoup()));
                                    grid.add(soupQuant, 6, x);
                                    grid.add(soup, 4, x);
                                    x++;
                                }
                                if (tables.get(i).getBeef() != 0) {
                                    beef.setText("Beef Steak");
                                    beef.setFont(Font.font(14));
                                    beefQuant.setText("X" + String.valueOf(tables.get(i).getBeef()));
                                    grid.add(beefQuant, 6, x);
                                    grid.add(beef, 4, x);
                                    x++;
                                }
                                if (tables.get(i).getFries() != 0) {
                                    fries.setText("Fried Potatos");
                                    fries.setFont(Font.font(14));
                                    friesQuant.setText("X" + String.valueOf(tables.get(i).getFries()));
                                    grid.add(friesQuant, 6, x);
                                    grid.add(fries, 4, x);
                                    x++;
                                }
                                if (tables.get(i).getSalade() != 0) {
                                    salade.setText("Greek Salade");
                                    salade.setFont(Font.font(14));
                                    saladeQuant.setText("X" + String.valueOf(tables.get(i).getSalade()));
                                    grid.add(saladeQuant, 6, x);
                                    grid.add(salade, 4, x);
                                    x++;
                                }
                                if (tables.get(i).getMolten() != 0) {
                                    molten.setText("Molten Cake");
                                    molten.setFont(Font.font(14));
                                    moltenQuant.setText("X" + String.valueOf(tables.get(i).getMolten()));
                                    grid.add(moltenQuant, 6, x);
                                    grid.add(molten, 4, x);
                                    x++;
                                }
                                if (tables.get(i).getApple() != 0) {
                                    apple.setText("Apple Pie");
                                    apple.setFont(Font.font(14));
                                    appleQuant.setText("X" + String.valueOf(tables.get(i).getApple()));
                                    grid.add(appleQuant, 6, x);
                                    grid.add(apple, 4, x);
                                    x++;
                                }
                                if (Count >= 4) {
                                    Label pages = new Label("Page 1 of 2");
                                    grid.add(pages, 6, 35);
                                    nextPage.setDisable(false);
                                } else {//set text
                                    Label pages = new Label("Page 1 of 1");
                                    grid.add(pages, 6, 35);
                                }
                            }
                        }
                        x++;
                    }
                    if (Count == 0 )
                    {
                        no.setText("There are no reservations for now");
                        grid.add(no,2,6);
                    }
            }
        });

        totalMoney.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label total = new Label();
                grid.add(total, 0, 32);
                Restaurant restaurant = null;
                try {
                    restaurant = verification.load2();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                List<ReservedTables> tables = restaurant.getTables().getReservedTables();

                double x = 0;
                for (int j = 0; j < tables.size(); j++) {
                    x += tables.get(j).getPaid();
                }
                total.setText("Total Money For Today : " + x);
                total.setFont(Font.font(18));
            }
        });

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginform.LoginScreen();
                stage.setScene(loginform.getScene());
            }
        });

        nextPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                next.Scene2();
                stage.setScene(next.getScene());
            }
        });


        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mangerPage.Scene2();
                stage.setScene(mangerPage.getScene());
            }
        });

        scene = new Scene(grid,1000,1000);



    }

    public Next getNext() {
        return next;
    }

    public void setNext(Next next) {
        this.next = next;
    }

    public void setMangerPage(MangerPage mangerPage) {
        this.mangerPage = mangerPage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setLoginform(Loginform loginform) {
        this.loginform = loginform;
    }
}