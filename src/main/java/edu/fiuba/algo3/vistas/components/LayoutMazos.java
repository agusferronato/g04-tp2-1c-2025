package edu.fiuba.algo3.vistas.components;

import edu.fiuba.algo3.controllers.ControladorJuego;
import edu.fiuba.algo3.modelo.Carta.Carta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class LayoutMazos {
    private final StackPane root;
    private HBox cartasJugadorBox;

    public LayoutMazos(Stage stage, SubmitButton button, ControladorJuego controlador) {
        cartasJugadorBox = new HBox(10);
        controlador.repartirCartas();
        inicializarSeccionCartas(controlador);

        BackgroundImage background = new BackgroundImage(stage, "/imagenes/backgroundElegirMazo.jpg");
        Text title = new Text("Choose your deck");
        title.setFill(Color.GOLD);
        Font cardinalFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Cardinal.ttf"), 100);
        title.setFont(cardinalFont);

        VBox titleBox = new VBox(30);
        titleBox.setAlignment(Pos.TOP_CENTER);
        titleBox.setPadding(new Insets(30, 20, 20, 20));
        titleBox.getChildren().add(title);


        Button botonComenzarPartida = button.getButton();
        botonComenzarPartida.setVisible(false);
        botonComenzarPartida.setText("Comenzar");

        SubmitButton botonSumarCartas = new SubmitButton(e -> {}, "Tomar");
        SubmitButton botonDejarElMazoIgual = new SubmitButton(e -> {}, "Dejar");

        botonSumarCartas.setOnAction(() -> {
            botonComenzarPartida.setVisible(true);
            botonDejarElMazoIgual.getButton().setVisible(false);
            botonSumarCartas.getButton().setVisible(false);
            controlador.tomarNuevasCartas();
            actualizarSeccionCartas(controlador);
        });


        botonDejarElMazoIgual.setOnAction(() -> {
            botonComenzarPartida.setVisible(true);
            botonDejarElMazoIgual.getButton().setVisible(false);
            botonSumarCartas.getButton().setVisible(false);
        });

        HBox botonesDecision = new HBox(20);
        botonesDecision.setAlignment(Pos.CENTER);
        botonesDecision.getChildren().addAll(
                botonSumarCartas.getButton(),
                botonDejarElMazoIgual.getButton()
        );

        VBox contenedorBotones = new VBox(20);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.getChildren().addAll(
                botonesDecision,
                botonComenzarPartida
        );

        VBox layoutCentral = new VBox(30);
        layoutCentral.setAlignment(Pos.CENTER);
        layoutCentral.getChildren().addAll(
                titleBox,
                cartasJugadorBox,
                contenedorBotones
        );


        root = new StackPane();
        root.getChildren().addAll(
                background.getImageView(),
                layoutCentral
        );
    }

    private void actualizarSeccionCartas (ControladorJuego controlador) {
        cartasJugadorBox.getChildren().clear();
        inicializarSeccionCartas(controlador);
    }


    private void inicializarSeccionCartas (ControladorJuego controlador) {
        cartasJugadorBox.setAlignment(Pos.CENTER);
        cartasJugadorBox.setPadding(new Insets(20, 10, 20, 10));

        List<Carta> cartasJugador = controlador.obtenerCartasJugador();
        for (Carta carta : cartasJugador) {
            Label cartaLabel = new Label(carta.getFormato());
            cartaLabel.setPrefSize(150, 250); // Tamaño tipo carta
            cartaLabel.setAlignment(Pos.CENTER);
            cartaLabel.setStyle(
                    "-fx-border-color: black;" +
                            "-fx-background-color: white;" +
                            "-fx-font-size: 12px;" +
                            "-fx-border-radius: 5px;" +
                            "-fx-background-radius: 5px;"
            );
            cartaLabel.setWrapText(true);
            cartasJugadorBox.getChildren().add(cartaLabel);
        }
    }

    public StackPane getRoot() {
        return root;
    }

}
