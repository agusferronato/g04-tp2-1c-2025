package edu.fiuba.algo3.vistas.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LayoutMazos {
    private final StackPane root;

    public LayoutMazos(Stage stage) {

        BackgroundImage background = new BackgroundImage(stage, "/imagenes/backgroundElegirMazo.jpg");
        Text title = new Text("Choose your deck");
        title.setFill(Color.GOLD);
        Font cardinalFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Cardinal.ttf"), 100);
        title.setFont(cardinalFont);

        VBox titleBox = new VBox(30);
        titleBox.setAlignment(Pos.TOP_CENTER);
        titleBox.setPadding(new Insets(30, 20, 20, 20));
        titleBox.getChildren().add(title);


        root = new StackPane();
        root.getChildren().addAll(
                background.getImageView(),
                titleBox
        );
    }
    public StackPane getRoot() {
        return root;
    }

}
