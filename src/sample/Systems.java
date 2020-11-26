package sample;

import Data.Restaurant;
import Functions.Verification;
import Gui.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.xml.bind.JAXBException;


public class Systems extends Application {



    public static void main(String[] args) throws JAXBException {
        Verification verification = new Verification();
        launch(args);
        Restaurant restaurant = verification.load();

//        for (User user : restaurant.getUsers().getUsers()) {
//            System.out.println(user.getName() + " " + user.getRole() + " " + user.getUsername());
//        }
//        for (Table table :restaurant.getTables().getTables()) {
////            System.out.println(table.getNumber());
//        }
//        for (Dish dish : restaurant.getDishes().getDishes())
//            System.out.println(dish.getName() + dish.getPrice());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("LA Dona");
        Loginform loginform = new Loginform(primaryStage);
        MangerPage mangerPage = new MangerPage(primaryStage);
        ClientPage clientPage = new ClientPage(primaryStage);
        CookerPage cookerPage = new CookerPage(primaryStage);
        WaiterPage waiterPage = new WaiterPage(primaryStage);
        Next next = new Next(primaryStage);
        Signup signup = new Signup(primaryStage);
        loginform.LoginScreen();
        mangerPage.Scene2();
        clientPage.Scene2();
        cookerPage.Scene2();
        waiterPage.Scene2();
        next.Scene2();
        signup.Scene2();
        loginform.setMangerPage(mangerPage);
        loginform.setClientPage(clientPage);
        loginform.setCookerPage(cookerPage);
        loginform.setWaiterPage(waiterPage);
        loginform.setSignup(signup);
        signup.setLoginform(loginform);
        mangerPage.setLoginform(loginform);
        mangerPage.setNext(next);
        mangerPage.setMangerPage(mangerPage);
        next.setMangerPage(mangerPage);
        clientPage.setLoginform(loginform);
        clientPage.setClientPage(clientPage);
        cookerPage.setLoginform(loginform);
        cookerPage.setCookerPage(cookerPage);
        waiterPage.setLoginform(loginform);
        waiterPage.setWaiterPage(waiterPage);
        primaryStage.setScene(loginform.getScene());
        primaryStage.show();
    }


}
