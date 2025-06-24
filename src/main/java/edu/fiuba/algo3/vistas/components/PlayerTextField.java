package edu.fiuba.algo3.vistas.components;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PlayerTextField{
    private final TextField textField;
    private final VBox container;

    public PlayerTextField() {
        textField = new TextField();
        textField.setPromptText("Ingresá tu nombre");
        Font cardinalFontLabel = Font.loadFont(getClass().getResourceAsStream("/fonts/Cardinal.ttf"), 50);
        Font cardinalFontField = Font.loadFont(getClass().getResourceAsStream("/fonts/Cardinal.ttf"), 32);
        textField.setFont(cardinalFontField);
        textField.setStyle(
                "-fx-background-color: #f7f0d3;" +
                        "-fx-border-color: gold;" +
                        "-fx-border-width: 3;" +
                        "-fx-border-radius: 8;" +
                        "-fx-background-radius: 8;" +
                        "-fx-text-fill: #4b2e05;" +
                        "-fx-prompt-text-fill: #8a6f3d;" +
                        "-fx-padding: 10 10;"

        );
        textField.setPrefHeight(75);
        textField.setPrefWidth(300);
        Label label = new Label("Nombre");
        label.setTextFill(Color.GOLD);
        label.setFont(cardinalFontLabel);

        container = new VBox(10, label, textField);
        container.setAlignment(Pos.CENTER_LEFT);

    }

    public VBox getTextField() {
        return container;
    }

    public String getNombre() {
        return textField.getText();
    }
}
