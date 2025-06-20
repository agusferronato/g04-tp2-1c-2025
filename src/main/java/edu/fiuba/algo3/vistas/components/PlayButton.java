package edu.fiuba.algo3.vistas.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.Cursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;


public class PlayButton {
    private final Button button;

    public PlayButton(EventHandler<ActionEvent> action) {
        button = new Button("PLAY");
        button.setPrefSize(250, 100);
        button.setStyle("-fx-font-size: 35px; -fx-background-color: #ffcc00; -fx-padding: 10 50; -fx-border-radius: 25px");
        button.setCursor(Cursor.HAND);

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

        button.setOnAction(action);
    }

    public Button getButton() {
        return button;
    }
}

