package edu.fiuba.algo3.vistas.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PlayerBox {
    private final StackPane frame;
    private final PlayerTextField nombreTextField;

    public PlayerBox() {

        //TITULO
        Text title = new Text("Creación Jugador");
        Font cardinalFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Cardinal.ttf"), 100);
        title.setFill(Color.GOLD);
        title.setFont(cardinalFont);

        StackPane titleBox = new StackPane(title);
        titleBox.setAlignment(Pos.TOP_CENTER);
        titleBox.setPadding(new Insets(40, 0, 0, 0));

        //INPUT
        this.nombreTextField = new PlayerTextField();

        StackPane fieldContainer = new StackPane(nombreTextField.getTextField());
        fieldContainer.setAlignment(Pos.CENTER);
        fieldContainer.setPadding(new Insets(0, 50, 50, 0));

        //TITULO E INPUT
        // Contenedor principal con BorderPane
        BorderPane frameContent = new BorderPane();
        frameContent.setTop(titleBox);
        frameContent.setCenter(fieldContainer);
        frameContent.setStyle("-fx-background-color: transparent;");



        frame = new StackPane(frameContent);
        frame.setStyle(
                "-fx-background-color: rgba(35,13,6,0.93);" +
                        "-fx-border-color: gold;" +
                        "-fx-border-width: 8;" +
                        "-fx-border-radius: 15;" +
                        "-fx-background-radius: 15;"
        );
        frame.setPadding(new Insets(40));
        frame.setMaxWidth(600);
        frame.setMaxHeight(900);
    }

    public StackPane getFrame() {
        return frame;
    }

    public String getNombreJugador() {
        return nombreTextField.getNombre();
    }

    public PlayerTextField getTextFieldComponent() {
        return nombreTextField;
    }
}
