package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.vistas.components.LayoutStart;
import edu.fiuba.algo3.vistas.components.PlayButton;
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
        PlayButton playButton = new PlayButton(e -> tablero(stage));
        LayoutStart mainLayout = new LayoutStart(stage, playButton);
        Scene scene = new Scene(mainLayout.getRoot(), 800, 600);
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