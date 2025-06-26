package edu.fiuba.algo3.vistas.components;

import edu.fiuba.algo3.modelo.LogicaGeneral.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.Cursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;


public class PlayButton {
    private final Button button;
    private Juego juego;

    public PlayButton(EventHandler<ActionEvent> action) {
        button = new Button("Jugar");
        Font cardinalFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Cardinal.ttf"), 50);
        button.setFont(cardinalFont);
        button.setPrefSize(250, 100);
        button.setStyle(
                "-fx-background-color: #ffcc00; " +
                        "-fx-background-radius: 25px; " +
                        "-fx-padding: 10 10  10; " +
                        "-fx-background-insets: 0;"
        );
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

