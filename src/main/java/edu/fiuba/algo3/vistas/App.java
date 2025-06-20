package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.vistas.components.LayoutStart;
import edu.fiuba.algo3.vistas.components.PlayButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        PlayButton playButton = new PlayButton(e -> elegirMazo(stage));
        LayoutStart mainLayout = new LayoutStart(stage, playButton);
        Scene scene = new Scene(mainLayout.getRoot(), 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }


    public void elegirMazo(Stage stage){

        Image fondo = new Image(getClass().getResourceAsStream("/imagenes/tryfondo1.jpg"));
        ImageView imageView = new ImageView(fondo);
        imageView.fitWidthProperty().bind(stage.widthProperty());
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.setPreserveRatio(false);


        Button btn = new Button();
        btn.setPrefHeight(100);
        btn.setPrefWidth(250);
        btn.setText("SUBMIT");
        btn.setStyle("-fx-font-size: 35px; -fx-background-color: #ffcc00; -fx-padding: 10 50; -fx-border-radius: 25px");
        btn.setCursor(Cursor.HAND);
        //btn.setOnAction(e -> tablero(stage));

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.setPadding(new Insets(20, 20, 50, 20));
        buttonBox.getChildren().add(btn);

        Text title = new Text("Creacion Jugador");
        title.setFill(Color.GOLD);
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 60));

        TextField nombre = new TextField();
        nombre.setPromptText("Nombre");

        StackPane frame = new StackPane();
        frame.setStyle(
                "-fx-background-color: rgba(35,13,6,0.93);" +
                        "-fx-border-color: gold;" +
                        "-fx-border-width: 8;" +
                        "-fx-border-radius: 15;" +
                        "-fx-background-radius: 15;"
        );
        frame.setPadding(new Insets(40));
        frame.getChildren().addAll(title, nombre);
        frame.setMaxWidth(600);


        StackPane root = new StackPane();
        root.getChildren().addAll(imageView, frame, buttonBox);

        StackPane.setAlignment(title, Pos.TOP_CENTER);
        StackPane.setAlignment(nombre, Pos.CENTER);
        StackPane.setAlignment(frame, Pos.TOP_CENTER);
        StackPane.setAlignment(buttonBox, Pos.BOTTOM_CENTER);
        StackPane.setMargin(frame, new Insets(75, 0, 90, 0)); // Margen superior

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setTitle("Creacion Jugador");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}