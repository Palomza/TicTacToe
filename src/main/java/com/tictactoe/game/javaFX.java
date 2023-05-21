package com.tictactoe.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class javaFX extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundFill backgroundFill = new BackgroundFill(Color.DARKGRAY, null, null);
        Background background = new Background((backgroundFill));

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource("/fxml/TestView.fxml"));
        GridPane gridPane = fxmlLoader.load();
        gridPane.setBackground(background);

        Scene scene = new Scene(gridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic tac toe");
        primaryStage.show();
    }
}
