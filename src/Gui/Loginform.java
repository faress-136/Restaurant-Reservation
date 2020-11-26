package Gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Functions.Verification;
import javax.xml.bind.JAXBException;
import java.io.IOException;


public class Loginform {
Stage stage;
MangerPage mangerPage;
ClientPage clientPage;
Scene scene ;
WaiterPage waiterPage;
CookerPage cookerPage;
Signup signup;
Verification verification = new Verification();


    public Loginform(Stage stage){
    this.stage = stage ;
}
    public void LoginScreen() {
        Label usernameLabel = new Label("Username : ");
        Label passwordlabel = new Label("Password : ");
        Label trial = new Label();
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button login = new Button("Login");
        Button signups = new Button("Sign up");



        GridPane grid = new GridPane();
        grid.setHgap(4);
        grid.setVgap(4);
        grid.add(usernameLabel,0,0);
        grid.add(passwordlabel,0,1);
        grid.add(usernameField,1,0);
        grid.add(passwordField,1,1);
        grid.add(login,2,2);
        grid.add(signups,3,2);
        grid.add(trial,8,8);


        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               String username= usernameField.getText();
               String password= passwordField.getText();
                String role="Empty";
                try {
                    role = verification.verify (username,password);
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                switch (role) {
                    case "Client":
                        stage.setScene(clientPage.getScene());
                        trial.setText("Welcome Client ");
                        System.out.println("Welcome Client");
                        break;
                    case "Manger":
                        mangerPage.Scene2();
                        stage.setScene(mangerPage.getScene());
                        System.out.println("Welcome Manager");
                        break;
                    case "Waiter":
                        try {
                            waiterPage.Scene2();
                        } catch (JAXBException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        stage.setScene(waiterPage.getScene());
                        trial.setText("Welcome Waiter! ");
                        break;
                    case "Cooker":
                        cookerPage.Scene2();
                        stage.setScene(cookerPage.getScene());
                        trial.setText("Welcome Cooker! ");
                        break;
                    case "Empty":
                        trial.setText("Wrong Username Or Password!");
                        break;
                }

                }
        });

        signups.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                signup.Scene2();
                stage.setScene(signup.getScene());
            }
        });




         scene = new Scene(grid, 500 , 300);
    }
    public Scene getScene(){
        return this.scene;
    }

    public void setMangerPage(MangerPage mangerPage) {
        this.mangerPage = mangerPage;
    }
    public void setClientPage(ClientPage clientPage) {
        this.clientPage = clientPage;
    }

    public void setWaiterPage(WaiterPage waiterPage) {
        this.waiterPage = waiterPage;
    }

    public void setCookerPage(CookerPage cookerPage) {
        this.cookerPage = cookerPage;
    }

    public void setSignup(Signup signup) {
        this.signup = signup;
    }
}
