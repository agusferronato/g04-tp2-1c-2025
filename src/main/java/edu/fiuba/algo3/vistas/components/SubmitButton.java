package edu.fiuba.algo3.vistas.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SubmitButton {
    private Button button;

    public SubmitButton(EventHandler<ActionEvent> action) {
        inicializarBoton(action);
    }

    private void inicializarBoton (EventHandler<ActionEvent> action) {
        button = new Button("Submit");
        button.setPrefHeight(40);
        button.setPrefWidth(120);
        Font cardinalFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Cardinal.ttf"), 20);
        button.setFont(cardinalFont);
        button.setStyle(
                "-fx-background-color: #ffcc00; " +
                        "-fx-background-radius: 25px; " +
                        "-fx-padding: 10 10  10; " +
                        "-fx-background-insets: 0;"
        );
        button.setCursor(Cursor.HAND);
        button.setOnAction(action);
        DropShadow outerGlow = new DropShadow();
        outerGlow.setColor(Color.web("#ffffaa"));
        outerGlow.setRadius(30);
        outerGlow.setSpread(0.6);

        InnerShadow innerGlow = new InnerShadow();
        innerGlow.setColor(Color.web("#ffffaa"));
        innerGlow.setRadius(20);
        innerGlow.setChoke(0.3);
        innerGlow.setInput(outerGlow);

        button.setOnMouseEntered(e -> button.setEffect(innerGlow));
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
