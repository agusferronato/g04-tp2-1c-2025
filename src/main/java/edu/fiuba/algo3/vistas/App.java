package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.SystemInfo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Cursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();

        Image fondo = new Image(getClass().getResourceAsStream("/imagenes/tryfondo2.png"));
        ImageView imageView = new ImageView(fondo);
        imageView.fitWidthProperty().bind(stage.widthProperty());
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.setPreserveRatio(false);

        Button btn = new Button();
        btn.setPrefHeight(100);
        btn.setPrefWidth(250);
        btn.setText("PLAY");
        btn.setStyle("-fx-font-size: 35px; -fx-background-color: #ffcc00; -fx-padding: 10 50; -fx-border-radius: 25px");
        btn.setCursor(Cursor.HAND);
        btn.setOnAction(e -> {
            tablero(stage);
        });
        DropShadow outerGlow = new DropShadow();
        outerGlow.setColor(Color.web("#ffffaa"));
        outerGlow.setRadius(30);
        outerGlow.setSpread(0.6);
        InnerShadow innerGlow = new InnerShadow();
        innerGlow.setColor(Color.web("#ffffaa"));
        innerGlow.setRadius(20);
        innerGlow.setChoke(0.3);
        innerGlow.setInput(outerGlow);

        btn.setOnMouseEntered(e -> btn.setEffect(innerGlow));
        btn.setOnMouseExited(e -> btn.setEffect(null));
        Text titulo = new Text("Gwent card game");
        titulo.setFill(Color.WHITE);
        titulo.setFont(Font.font("Comic Sans MS",FontWeight.BOLD, FontPosture.ITALIC, 100));



        VBox tittleBox = new VBox(30);
        tittleBox.setAlignment(Pos.TOP_CENTER);
        tittleBox.setPadding(new Insets(30, 20, 20, 20));
        tittleBox.getChildren().addAll(titulo);



        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.setPadding(new Insets(20, 20, 50, 20));
        buttonBox.getChildren().addAll(btn);



        root.getChildren().addAll(imageView, tittleBox, buttonBox);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

    }

    public void tablero(Stage stage){
        StackPane tableroRoot = new StackPane();

        Image fondo = new Image(getClass().getResourceAsStream("/imagenes/tryfondo1.jpg"));
        ImageView imageView = new ImageView(fondo);
        imageView.fitWidthProperty().bind(stage.widthProperty());
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.setPreserveRatio(false);

        Button backBtn = new Button();
        backBtn.setPrefHeight(75);
        backBtn.setPrefWidth(200);
        backBtn.setText("BACK");
        backBtn.setStyle("-fx-font-size: 24px; -fx-background-color: #ffcc00; -fx-padding: 10 50;");
        backBtn.setCursor(Cursor.HAND);
        backBtn.setOnAction(e -> {
            start(stage);
        });

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.TOP_LEFT);
        buttonBox.setPadding(new Insets(30, 20, 20, 50));
        buttonBox.getChildren().addAll(backBtn);


        Text titulo = new Text("Board");
        titulo.setFont(Font.font("Comic Sans MS",FontWeight.BOLD, FontPosture.ITALIC, 100));
        titulo.setFill(Color.WHITE);
        titulo.setEffect(new javafx.scene.effect.DropShadow(10, Color.BLACK));
        titulo.setEffect(new DropShadow(10, Color.BLACK));


        VBox tittleBox = new VBox(30);
        tittleBox.setAlignment(Pos.TOP_CENTER);
        tittleBox.setPadding(new Insets(20, 20, 20, 20));
        tittleBox.getChildren().addAll(titulo);


        tableroRoot.getChildren().addAll(imageView, tittleBox, buttonBox);

        Scene scene = new Scene(tableroRoot, 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}