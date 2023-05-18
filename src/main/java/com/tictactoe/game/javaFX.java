package com.tictactoe.game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class javaFX extends Application {

    private Image imageback = new Image("img/tictactoe3x3.png");
    private Image imagexMark = new Image("img/xMarkImage.png");
    private FlowPane imageMarks = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);

        ImageView img = new ImageView(imagexMark);
        img.setFitHeight(250);
        img.setFitWidth(250);
        imageMarks.getChildren().add(img);

        grid.add(imageMarks, 0,0,1,1);

        Scene scene = new Scene(grid, 900, 900, Color.MIDNIGHTBLUE);

        primaryStage.setTitle("Tic tac toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
