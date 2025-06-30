package edu.fiuba.algo3.vistas.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SubmitButton {
    private Button button;

    public SubmitButton(EventHandler<ActionEvent> action) {
        inicializarBoton(action);
    }

    private void inicializarBoton (EventHandler<ActionEvent> action) {
        button = new Button("Crear");
        button.setPrefHeight(40);
        button.setPrefWidth(120);
        Font cardinalFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Cardinal.ttf"), 20);
        button.setFont(cardinalFont);
        button.setStyle(
                "-fx-background-color: #ffcc00; " +
                        "-fx-background-radius: 5px; " +
                        "-fx-padding: 10 10  10; " +
                        "-fx-background-insets: 0;"
        );
        button.setCursor(Cursor.HAND);
        button.setOnAction(action);
        DropShadow outerGlow = new DropShadow();
        outerGlow.setColor(Color.web("#ffffaa"));
        outerGlow.setRadius(15);
        outerGlow.setSpread(0.3);

        InnerShadow innerGlow = new InnerShadow();
        innerGlow.setColor(Color.web("#ffffaa"));
        innerGlow.setRadius(10);
        innerGlow.setChoke(0.1);
        innerGlow.setInput(outerGlow);

        button.setOnMouseEntered(e -> button.setEffect(outerGlow));
        button.setOnMouseExited(e -> button.setEffect(null));
    }

    public SubmitButton(EventHandler<ActionEvent> action, String texto) {
        inicializarBoton(action);
        button.setText(texto);
    }

    public Button getButton() {
        return button;
    }

    public void setOnAction(Runnable action) {
        button.setOnAction(e -> action.run());
    }
}
