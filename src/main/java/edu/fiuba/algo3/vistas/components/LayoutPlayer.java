package edu.fiuba.algo3.vistas.components;

import edu.fiuba.algo3.controllers.ControladorJuego;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LayoutPlayer {
    private final StackPane root;

    public LayoutPlayer(Stage stage, SubmitButton button, ControladorJuego controlador) {

        BackgroundImage backgroundImage = new BackgroundImage(stage, "/imagenes/tryfondo1.jpg");

        PlayerBox frame = new PlayerBox();

        EventHandler<ActionEvent> originalButton = button.getButton().getOnAction();

        button.getButton().setOnAction(e -> {
            String nombre = frame.getNombreJugador();
            if (!nombre.trim().isEmpty()) {
                controlador.nombreSeleccionado(nombre);
            }
            originalButton.handle(e);
        });

        HBox buttonBox = new HBox(button.getButton());
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.setPadding(new Insets(20, 20, 50, 20));
        frame.getFrame().maxWidthProperty().bind(stage.widthProperty().multiply(0.3));
        frame.getFrame().maxHeightProperty().bind(stage.heightProperty().multiply(0.9));
        frame.getFrame().getChildren().add(buttonBox);
        root = new StackPane();
        root.getChildren().addAll(
                backgroundImage.getImageView(),
                frame.getFrame()
        );

    }
    public StackPane getRoot() {
        return root;
    }
}
