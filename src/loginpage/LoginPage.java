/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author sami-
 */
public class LoginPage extends Application {

    TextField userTextField;
    PasswordField passwordField;
    Stage primary;
    boolean isFullScreen = false;
    Image img;
    Label wlcLabel;
    Tooltip tooltip;
    Button MaxOrMinBtn;

    @Override
    public void start(Stage primaryStage) {
        primary = primaryStage;
        Label welcomeLabel = new Label();
        welcomeLabel.setText("Welcome to Model");
        welcomeLabel.setUnderline(true);
        welcomeLabel.setTextFill(javafx.scene.paint.Color.RED);
        welcomeLabel.setFont(Font.font("Freestyle Script", FontWeight.BOLD, FontPosture.ITALIC, 26));

        Label adsLabel = new Label("ads");
        Label copyrightLbl = new Label("\u00a9 2022 Model by Ahmed Hammad ^_^");

        HBox hBox = createHBox();

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(welcomeLabel);
        BorderPane.setAlignment(welcomeLabel, Pos.CENTER);
        borderPane.setRight(adsLabel);
        GridPane gridPane = createGrid();
        gridPane.setAlignment(Pos.CENTER);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(copyrightLbl);

        Scene scene = new Scene(borderPane, 400, 400);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Model");
        primaryStage.getIcons().add(new Image("/logo.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @return 
     */
    public GridPane createGrid() {
        Label userLabel = new Label("User Name");
        userTextField = new TextField();
        userTextField.setPromptText("Enter user name please");

        Label password = new Label("Password");
        passwordField = new PasswordField();
        passwordField.setPromptText("Enter password please");
        VBox vBox = createVBox();
        vBox.setAlignment(Pos.CENTER);

        HBox hbox = createHBox();
        hbox.setAlignment(Pos.CENTER);

        GridPane gp = new GridPane();
        gp.add(vBox, 1, 0);
        gp.addRow(1, userLabel, userTextField);
        gp.addRow(2, password, passwordField);
        gp.add(hbox, 1, 3);
        gp.setHgap(10);
        gp.setVgap(10);
        return gp;
    }

    public VBox createVBox() {
        wlcLabel = new Label("Welcome User");
        wlcLabel.setFont(Font.font("Freestyle Script", FontWeight.BOLD, 26));
        Label loginlbl = new Label("Login Form");   
        VBox vBox = new VBox();
        vBox.getChildren().add(wlcLabel);
        vBox.getChildren().add(loginlbl);
        return vBox;
    }

    public HBox createHBox() {
        Button getUserNameButton = new Button("Get Username");
        getUserNameButton.setPrefSize(100, 35);
        getUserNameButton.setTooltip(new Tooltip("get User Name"));
        getUserNameButton.setOnAction((ActionEvent event) -> {
            if (!(userTextField.getText().equals(""))) {
                wlcLabel.setText("Hello " + userTextField.getText());
                System.out.println("User Name = " + userTextField.getText());
            }
        });
        Button getPasswordButton = new Button("Get Password");
        getPasswordButton.setTooltip(new Tooltip("get Password"));
        getPasswordButton.setPrefSize(100, 35);
        getPasswordButton.setOnAction((ActionEvent event) -> {
            if (!(passwordField.getText().equals(""))) {
                System.out.println("Password = " + passwordField.getText());
            }
        });
        MaxOrMinBtn = new Button();
        img = new Image(getClass().getResourceAsStream("/icons8_fit_to_width_16.png"));
        ImageView imgView = new ImageView(img);
        MaxOrMinBtn.setGraphic(imgView);
        MaxOrMinBtn.setPrefSize(35, 35);
        MaxOrMinBtn.setTooltip(new Tooltip("Full Screen"));
        MaxOrMinBtn.setOnAction((ActionEvent event) -> {
            if (isFullScreen == false) {
                primary.setFullScreen(true);
                img = new Image(getClass().getResourceAsStream("/icons8_normal_screen_16.png"));
                ImageView imgView1 = new ImageView(img);
                MaxOrMinBtn.setGraphic(imgView1);
                MaxOrMinBtn.setTooltip(new Tooltip("Exit Full Screen"));
                isFullScreen = true;
            } else {
                img = new Image(getClass().getResourceAsStream("/icons8_fit_to_width_16.png"));
                ImageView imgView2 = new ImageView(img);
                MaxOrMinBtn.setGraphic(imgView2);
                isFullScreen = false;
                MaxOrMinBtn.setTooltip(new Tooltip("Full Screen"));
                primary.setFullScreen(false);
            }
        });
        HBox hBox = new HBox();
        hBox.setSpacing(5.0);
        hBox.getChildren().add(getUserNameButton);
        hBox.getChildren().add(getPasswordButton);
        hBox.getChildren().add(MaxOrMinBtn);
        return hBox;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
