package Gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Data.ReservedTables;
import Data.Restaurant;
import Functions.Verification;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;


public class WaiterPage {
    Stage stage ;
    Loginform loginform;
    Scene scene ;
    Verification verification = new Verification();
    WaiterPage waiterPage;

    public WaiterPage(Stage stage){
        this.stage=stage;
    }

    public void Scene2() throws JAXBException, IOException {

        Button reservations_ = new Button("Check Reservations ");
        Label title = new Label("Scheduled Reservations");
        title.setFont(Font.font("Verdana" , 20));
        Button logout = new Button("Logout");
        Button clear = new Button("Clear");

        reservations_.setDisable(true);
        ChoiceBox<String> time = new ChoiceBox<>() ;
        time.getItems().addAll("6","7","8","9","10","11","12","1","2");
        Label pm = new Label();
        Label suitable = new Label("Please choose time:");
        time.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (time.getValue().equals("12") || time.getValue().equals("1") || time.getValue().equals("2") ){
                    pm.setText(":00  am");
                    reservations_.setDisable(false);
                }
                else {
                    pm.setText(":00 pm");
                    reservations_.setDisable(false);
                }

            }
        });

        GridPane grid = new GridPane();
        grid.setVgap(6);
        grid.setHgap(6);
        grid.add(title,0,0);
        grid.add(logout,8,18);
        grid.add(suitable,0,2);
        grid.add(time,2,2);
        grid.add(pm,3,2);
        grid.add(reservations_,0,15);
        grid.add(clear,4,15);


        reservations_.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int X=5;
                time.setDisable(true);
                reservations_.setDisable(true);
                Restaurant restaurant = null;
                try {
                    restaurant = verification.load2();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }

                List<ReservedTables> tableslist = restaurant.getTables().getReservedTables() ;

                Label Client_Name = new Label("Client Name");
                Label Table_Number = new Label("Table Number");

                grid.add(Client_Name,0,4);
                grid.add(Table_Number,2,4);





                int count =0;
                for (int i=0 ; i<tableslist.size() ; i++) {
                    if (tableslist.get(i).getTime().equals(time.getValue()))
                    {
                        count++;
                        Label tableno = new Label();
                        Label clientname = new Label();
                        clientname.setText(tableslist.get(i).getName());
                        tableno.setText(tableslist.get(i).getNumber());
                        grid.add(clientname, 0, X);
                        grid.add(tableno, 2, X);
                        X++;
                    }
                }
                if (count==0)
                {
                    Label no = new Label("There are no clients for this hour");
                    grid.add(no,0,8 );
                }
            }
        });


        scene = new Scene(grid,600,600);

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginform.LoginScreen();
                stage.setScene(loginform.getScene());


            }
        });
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    waiterPage.Scene2();
                } catch (JAXBException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setScene(waiterPage.getScene());
            }
        });
    }

    public Scene getScene() {
        return scene;
    }

    public void setLoginform(Loginform loginform) {
        this.loginform = loginform;
    }

    public void setWaiterPage(WaiterPage waiterPage) {
        this.waiterPage = waiterPage;
    }
}
