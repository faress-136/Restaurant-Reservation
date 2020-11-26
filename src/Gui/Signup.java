package Gui;

import java.awt.*;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class Signup {
    Verification verification= new Verification();
    Loginform loginform;
    Scene scene;
    Stage stage;

    public Signup(Stage stage) {
        this.stage=stage;
    }

    public void Scene2(){

    Label title = new Label("Sign Up");
    Label username = new Label("Please Enter Your Username");
    Label password = new Label("Please Enter Your Password");
    Label fullName = new Label("Please Enter Your Full Name");
    Label succes   = new Label("Successfully Signed Up ! Please Return To The Login Screen " );
    Button signup = new Button("Sign up");
    Button login = new Button("Return to login");
    TextField usernameEntry = new TextField();
    PasswordField passwordEntry = new PasswordField();
    TextField fullnameEntry = new TextField();


    GridPane grid = new GridPane();
    grid.setHgap(4);
    grid.setVgap(4);
    grid.add(title,0,0);
    grid.add(username,0,1);
    grid.add(usernameEntry,1,1);
    grid.add(password,0,2);
    grid.add(passwordEntry,1,2);
    grid.add(fullName,0,3);
    grid.add(fullnameEntry,1,3);
    grid.add(signup,1,4);
    grid.add(login, 2,4);

    signup.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                verification.save2(fullnameEntry.getText(),usernameEntry.getText(),passwordEntry.getText());
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            grid.add(succes,1,4);
        }
    });

    login.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            loginform.LoginScreen();
            stage.setScene(loginform.getScene());
        }
    });


 scene = new Scene(grid,600,300);
}
    public Scene getScene() {
        return scene;
    }


    public void setLoginform(Loginform loginform) {
        this.loginform = loginform;
    }
}
