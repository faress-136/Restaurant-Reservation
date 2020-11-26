package Gui;

import Data.ReservedTables;
import Data.Restaurant;
import Functions.Calculations;
import Functions.Verification;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.util.List;

public class ClientPage {
    Stage stage ;
    Loginform loginform ;
    ClientPage clientPage;
    Scene scene ;
    Verification verification = new Verification();
    Calculations calculations = new Calculations();


   private int salad=0;
   private int chicken=0;
   private int beef=0;
   private int fries=0;
   private int soup=0;
   private int molten=0;
   private int apple=0;
   String tim = "No";


    public ClientPage(Stage stage){
        this.stage=stage;
    }


    public void Scene2() throws JAXBException {
        Restaurant restaurant = verification.load2();
        List<ReservedTables> tableslist = restaurant.getTables().getReservedTables() ;

        Label welcome = new Label("Welcome  " );
        Button logout = new Button("Logout");
        Label seats =new Label ("Please enter the number of seats");
        TextField seatsno = new TextField();

        Label name = new Label("Please enter your name for order confirmation :") ;
        TextField named = new TextField();
        Label choose = new Label("Please Choose : ");
        ToggleGroup group = new ToggleGroup();
        RadioButton smoking = new RadioButton("Smoking");
        RadioButton nonsmoking = new RadioButton("Non-Smoking");
        smoking.setSelected(true);
        smoking.setToggleGroup(group);
        nonsmoking.setToggleGroup(group);
        Button confirm = new Button("Confirm");
        ChoiceBox <String> seated = new ChoiceBox<>() ;
        seated.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
        ChoiceBox <String> time = new ChoiceBox<>() ;
        time.getItems().addAll("6","7","8","9","10","11","12","1","2");
        Label pm = new Label();
        Label suitable = new Label("Please choose a suitable time:");
        time.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (time.getValue().equals("12") || time.getValue().equals("1") || time.getValue().equals("2") ){
                    pm.setText(":00  am");
                    tim = time.getValue();
                }
                else
                {
                    pm.setText(":00 pm");
                    tim = time.getValue();
                }
            }
        });




        Label available = new Label();
        Label pleaseOrder = new Label("Please Order : ");
        Button menu = new Button("Menu");

        ComboBox <String> appetizers = new  ComboBox();
        appetizers.getItems().addAll("Greek Salade" ,"Fried Potatos" );
        appetizers.setPromptText("Appetizers");
        ComboBox <String> appetizersno = new ComboBox();
        appetizersno.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15");
        appetizersno.setPromptText("Quantity");
        Button addappitizers = new Button("Add");
        ComboBox <String> mainCourse = new ComboBox();
        mainCourse.getItems().addAll("Grilled Chicken" ,"Mushroom Soup" , "Beef Steak");
        mainCourse.setPromptText("Main Course");
        ComboBox <String> maincourseno = new ComboBox();
        maincourseno.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15");
        maincourseno.setPromptText("Quantity");
        Button addmaincourse = new Button("Add");
        ComboBox <String> deserts = new ComboBox();
        deserts.getItems().addAll("Molten Cake" ,"Apple Pie");
        deserts.setPromptText("Deserts");
        ComboBox <String> desertsno = new ComboBox();
        desertsno.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15");
        desertsno.setPromptText("Quantity");
        Button adddeserts = new Button("Add");


        Label thank = new Label();
        Button confirm2 = new Button("Confirm");




        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(welcome,0,0);

        grid.add(seats,0,1);
        grid.add(seated,1,1);
        grid.add(choose,0,2);
        grid.add(smoking,2,2);
        grid.add(nonsmoking,1,2);
        grid.add(suitable,0,3);
        grid.add(time,1,3);
        grid.add(pm,2,3);

        grid.add(confirm,3,4);

        grid.add(available,2 ,4);






        grid.add(logout,0,25);

        scene = new Scene(grid,1000,1000);

        Button check = new Button("Check Order");
        grid.add(check,6,22 );
        Label getname = new Label("Please Enter Your Name:" );
        TextField getnames = new TextField();

        Button restart = new Button("New Order");
        grid.add(restart,4,22);
        restart.setDisable(true);

        confirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String Smoke="0";
                if (smoking.isSelected()){
                      Smoke = "true"; }
                else if (nonsmoking.isSelected()){
                    Smoke="false"; }
                String Seats = seated.getValue();
                String Available="Not Available";

                try {
                    Available = verification.checkTable( Smoke ,Seats , tim );
                } catch (JAXBException e) {
                    e.printStackTrace();
                }

                if (Available != "Not Available")
                {
                    confirm.setDisable(true);
                    restart.setDisable(false);
                    seated.setDisable(true);
                    menu.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                            Stage popupwindow = new Stage();

                            popupwindow.initModality(Modality.APPLICATION_MODAL);
                            popupwindow.setTitle("Menu");
// add tax percentage
                            Label title1 = new Label("Appetizers");
                            title1.setFont(new Font(15));
                            Label title2 = new Label("Main Course");
                            title2.setFont(new Font(15));
                            Label title3 = new Label("Deserts");
                            title3.setFont(new Font(15));
                            Label label1 = new Label();
                            Label label2 = new Label();
                            Label label3 = new Label();
                            Label label4 = new Label();
                            Label label5 = new Label();
                            Label label6 = new Label();
                            Label label7 = new Label();
                            Label label8 = new Label();
                            Button close = new Button("Close");
                            close.setOnAction(e -> popupwindow.close());


                            GridPane grid2 = new GridPane();
                            grid2.setVgap(6);
                            grid2.setHgap(6);
                            grid2.add(title1, 0, 1);
                            grid2.add(label1, 0, 2);
                            grid2.add(label2, 0, 3);
                            grid2.add(title2, 0, 4);
                            grid2.add(label3, 0, 5);
                            grid2.add(label4, 0, 6);
                            grid2.add(label5, 0, 7);
                            grid2.add(title3, 0, 8);
                            grid2.add(label6, 0, 9);
                            grid2.add(label7, 0, 10);

                            label1.setText("Green Salade          35 ");
                            label2.setText("Fried Potatos          30 ");
                            label3.setText("Grilled Chicken            75 ");
                            label4.setText("Mushroom Soup         60 ");
                            label5.setText("Beef Steak                   80 ");
                            label6.setText("Apple Pie             50 ");
                            label7.setText("Molten Cake          60 ");

                            Scene scene1 = new Scene(grid2, 300, 300);
                            popupwindow.setScene(scene1);
                            popupwindow.showAndWait();
                        }
                    });

                    available.setText("Table " + Available + " is Available");
                    grid.add(pleaseOrder,0,5);
                    grid.add(menu,1,5);
                    grid.add(appetizers,0,6);
                    grid.add(mainCourse,0,7);
                    grid.add(deserts,0,8);
                    grid.add(appetizersno,1,6);
                    grid.add(maincourseno,1,7);
                    grid.add(desertsno,1,8);
                    grid.add(addappitizers,2,6);
                    grid.add(addmaincourse,2,7);
                    grid.add(adddeserts,2,8);
                    Label Salad= new Label();
                    Label Fried = new Label();
                    Label Chicken= new Label();
                    Label Soup= new Label();
                    Label Beef= new Label();
                    Label Molten= new Label();
                    Label Apple= new Label();
                    grid.add(Salad,0 , 11 );
                    grid.add(Fried,0 , 12 );
                    grid.add(Chicken,0 , 14 );
                    grid.add(Soup,0 , 15 );
                    grid.add(Beef,0 , 16 );
                    grid.add(Molten, 0, 18);
                    grid.add(Apple, 0, 19);

                    addappitizers.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Label order = new Label("Your Order");
                            order.setFont(Font.font(16));
                            grid.add(order,0,9);
                            Label appetizerss = new Label("Appetizers ");
                            appetizerss.setFont(Font.font(14));
                            grid.add(appetizerss,0,10);
                            if (appetizers.getValue().equals("Greek Salade")){
                                try {
                                    Salad.setText("Greek Salade    " + "  Quantity X" + appetizersno.getValue() + "   " +  calculations.calculate("Greek Salade", Integer.parseInt(appetizersno.getValue())));
                                } catch (JAXBException e) {
                                    e.printStackTrace();
                                }
                                salad = Integer.parseInt(appetizersno.getValue());
                            }
                            if (appetizers.getValue().equals("Fried Potatos")) {
                                try {
                                    Fried.setText("Fried Potatos    " + "  Quantity X" + appetizersno.getValue() + "   " + calculations.calculate("Fried Potatos", Integer.parseInt(appetizersno.getValue())));
                                } catch (JAXBException e) {
                                    e.printStackTrace();
                                }
                                fries = Integer.parseInt(appetizersno.getValue());
                            }
                        }
                    });
                    addmaincourse.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Label order = new Label("Your Order");
                            order.setFont(Font.font(16));
                            grid.add(order,0,9);
                            Label mains = new Label("Main Course : ");
                            mains.setFont(Font.font(14));
                            grid.add(mains,0,13);
                            if (mainCourse.getValue().equals("Grilled Chicken")) {
                                try {
                                    Chicken.setText("Grilled Chicken   " + "  Quantity X" + maincourseno.getValue() + "   " + calculations.calculate("Grilled Chicken", Integer.parseInt(maincourseno.getValue())));
                                } catch (JAXBException e) {
                                    e.printStackTrace();
                                }
                                chicken =Integer.parseInt(maincourseno.getValue());
                            }
                            if (mainCourse.getValue().equals("Mushroom Soup")){
                                try {
                                    Soup.setText("Mushroom Soup    " + "  Quantity X" + maincourseno.getValue() + "   " + calculations.calculate("Mushroom Soup" ,Integer.parseInt(maincourseno.getValue())));
                                } catch (JAXBException e) {
                                    e.printStackTrace();
                                }
                                soup= Integer.parseInt(maincourseno.getValue());
                            }

                            if (mainCourse.getValue().equals("Beef Steak")){
                                try {
                                    Beef.setText("Beef Steak    " + "  Quantity X" + maincourseno.getValue() + "   " + calculations.calculate("Beef Steak" ,Integer.parseInt(maincourseno.getValue())));
                                } catch (JAXBException e) {
                                    e.printStackTrace();
                                }

                                beef = Integer.parseInt(maincourseno.getValue());
                            }
                    }
                    });
                    adddeserts.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Label order = new Label("Your Order");
                            order.setFont(Font.font(16));
                            grid.add(order,0,9);
                            Label desertt = new Label("Deserts : ");
                            desertt.setFont(Font.font(14));
                            grid.add(desertt,0,17);
                            if (deserts.getValue().equals("Molten Cake")) {
                                try {
                                    Molten.setText("Molten Cake    " + "  Quantity X" + desertsno.getValue() + "   " + calculations.calculate("Molten Cake", Integer.parseInt(desertsno.getValue())));
                                } catch (JAXBException e) {
                                    e.printStackTrace();
                                }
                                molten = Integer.parseInt(desertsno.getValue());
                            }
                            if (deserts.getValue().equals("Apple Pie")) {
                                try {
                                    Apple.setText("Apple Pie    " + "  Quantity X" + desertsno.getValue() + "   " + calculations.calculate("Apple Pie", Integer.parseInt(desertsno.getValue())));
                                } catch (JAXBException e) {
                                    e.printStackTrace();
                                }
                                apple = Integer.parseInt(desertsno.getValue()) ;
                            }
                        }
                    });


                    grid.add(name,0,21);
                    grid.add(named,1,21);
                    grid.add(confirm2,2,22);

                    confirm2.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                            confirm2.setDisable(true);
                            Label total = new Label();
                            total.setText("Total Price : " + String.valueOf(calculations.getTotalprice()));
                            total.setFont(Font.font(16));
                            grid.add(total,0,20);

                            try {
                                verification.save(named.getText() ,verification.getTableno(), tim ,calculations.getTotalprice(),salad,fries,chicken,beef,soup,molten,apple);
                            } catch (JAXBException e) {
                                e.printStackTrace();
                            }

                            thank.setText("Thank You Mr." + named.getText() + " your order has been successfully added ");
                            grid.add(thank,0,22);
                        }
                    });
                }else {
                    available.setText(("There are No Available tables"));
                    System.out.println("Would You Like To Reserve a Table");
                }
            }

        });

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginform.LoginScreen();
                try {
                    clientPage.Scene2();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                stage.setScene(loginform.getScene());


            }
        });
    check.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Stage popupwindow = new Stage();

            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("Your Order");
            GridPane grid3 =new GridPane();
            grid3.setHgap(4);
            grid3.setVgap(4);
            Label getname = new Label("Please Enter Your Name:" );
            TextField getnames = new TextField();
            Label Salad= new Label();
            Label Fried = new Label();
            Label Chicken= new Label();
            Label Soup= new Label();
            Label Beef= new Label();
            Label Molten= new Label();
            Label Apple= new Label();
            Button checks = new Button("Check Order");
            grid3.add(getname,0,0);
            grid3.add(getnames,1,0);
            grid3.add(checks,1,1);

            checks.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        Restaurant restaurant1 = verification.load2();
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                    List<ReservedTables> res = restaurant.getTables().getReservedTables() ;
                    int m;
                    int z=4;
                    for(m=0;m<res.size();m++) {
                        if (res.get(m).getName().equalsIgnoreCase(getnames.getText())) {
                            if (res.get(m).getSalade() != 0) {
                                Salad.setText("Greek Salade    X" + res.get(m).getSalade());
                                grid3.add(Salad, 0, z);
                                z++;
                            }
                            if (res.get(m).getFries() != 0) {
                                Fried.setText("Fried Potatos    X" + res.get(m).getFries());
                                grid3.add(Fried, 0, z);
                                z++;
                            }
                            if (res.get(m).getGrilled() != 0) {
                                Chicken.setText("Grilled Chicken   X" + res.get(m).getGrilled());
                                grid3.add(Chicken, 0, z);
                                z++;
                            }
                            if (res.get(m).getSoup() != 0) {
                                Soup.setText("Mushroom Soup    X" + res.get(m).getSoup());
                                grid3.add(Soup, 0, z);
                                z++;
                            }
                            if (res.get(m).getBeef() != 0) {
                                Beef.setText("Beef Steak    X" + res.get(m).getBeef());
                                grid3.add(Beef, 0, z);
                                z++;
                            }
                            if (res.get(m).getMolten() != 0) {
                                Molten.setText("Molten Cake    X" + res.get(m).getMolten());
                                grid3.add(Molten, 0, z);
                                z++;
                            }
                            if (res.get(m).getApple() != 0) {
                                Apple.setText("Apple Pie    X" + res.get(m).getApple());
                                grid3.add(Apple, 0, z);
                                z++;
                            }
                        }
                    }
                }
            });



            Scene scene1 = new Scene(grid3, 400, 400);
            popupwindow.setScene(scene1);
            popupwindow.showAndWait();

        }
    });

    restart.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                clientPage.Scene2();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            stage.setScene(clientPage.getScene());

        }
    });

    }


    public Scene getScene() {
        return scene;
    }

    public void setLoginform(Loginform loginform) {
        this.loginform = loginform;
    }

    public void setClientPage(ClientPage clientPage){
        this.clientPage = clientPage ;
    }

}
