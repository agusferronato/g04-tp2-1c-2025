package edu.fiuba.algo3.vistas.components;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
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

    public LayoutPlayer(Stage stage, SubmitButton button) {

        BackgroundImage backgroundImage = new BackgroundImage(stage, "/imagenes/tryfondo1.jpg");

        PlayerBox frame = new PlayerBox();

        EventHandler<ActionEvent> originalButton = button.getButton().getOnAction();

        button.getButton().setOnAction(e -> {
            String nombre = frame.getNombreJugador();
            if (!nombre.trim().isEmpty()) {
                Jugador jugador = new Jugador(nombre);
                System.out.println("Jugador creado: " + nombre);
            }
            originalButton.handle(e);
        });

        HBox buttonBox = new HBox(button.getButton());
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.setPadding(new Insets(20, 20, 50, 20));

        root = new StackPane();
        root.getChildren().addAll(
                backgroundImage.getImageView(),
                frame.getFrame(),
                buttonBox
        );
        System.out.println("asd");
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setTitle("Creación Jugador");
        stage.show();

    }
    public StackPane getRoot() {
        return root;
    }
}
