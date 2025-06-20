package edu.fiuba.algo3.vistas.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TitleBox {
    private final StackPane titleContainer;

    public TitleBox() {
        Text title = new Text("Gwent card game");
        title.setFill(Color.GOLD);
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 70));

        VBox titleBox = new VBox(30);
        titleBox.setAlignment(Pos.TOP_CENTER);
        titleBox.setPadding(new Insets(30, 20, 20, 20));
        titleBox.getChildren().add(title);

        StackPane marco = new StackPane();
        marco.setStyle(
                "-fx-background-color: rgba(35,13,6,0.93);" +
                        "-fx-border-color: gold;" +
                        "-fx-border-width: 8;" +
                        "-fx-border-radius: 15;" +
                        "-fx-background-radius: 15;"
        );
        marco.setPadding(new Insets(5));
        marco.getChildren().add(titleBox);
        marco.setMaxSize(250, 75);
        marco.setPrefSize(600, 200);

        this.titleContainer = marco;
    }

    public StackPane getTitleContainer() {
        return titleContainer;
    }
}
