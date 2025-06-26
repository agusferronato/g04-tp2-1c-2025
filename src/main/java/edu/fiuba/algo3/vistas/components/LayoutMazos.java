package edu.fiuba.algo3.vistas.components;

import edu.fiuba.algo3.controllers.ControladorJuego;
import edu.fiuba.algo3.modelo.Carta.Carta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import javafx.scene.control.Tooltip;
public class LayoutMazos {
    private StackPane root;

    public LayoutMazos(Stage stage, SubmitButton button, ControladorJuego controlador) {
        controlador.repartirCartas();

        // Fondo
        BackgroundImage background = new BackgroundImage(stage, "/imagenes/backgroundElegirMazo.jpg");

        // Título
        Text title = new Text("Choose your deck");
        title.setFill(Color.GOLD);
        Font cardinalFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Cardinal.ttf"), 80);
        title.setFont(cardinalFont);
        VBox titleBox = new VBox(title);
        titleBox.setAlignment(Pos.TOP_CENTER);
        titleBox.setPadding(new Insets(30, 20, 20, 20));

        // Grid con cartas
        GridPane gridCartas = inicializarGridCartas(controlador);
        gridCartas.setMaxHeight(Double.MAX_VALUE);
        VBox.setVgrow(gridCartas, Priority.ALWAYS);

        // Botones
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
            actualizarGridCartas(gridCartas, controlador);
        });

        botonDejarElMazoIgual.setOnAction(() -> {
            botonComenzarPartida.setVisible(true);
            botonDejarElMazoIgual.getButton().setVisible(false);
            botonSumarCartas.getButton().setVisible(false);
        });

        HBox botonesDecision = new HBox(20,
                botonSumarCartas.getButton(),
                botonDejarElMazoIgual.getButton()
        );
        botonesDecision.setAlignment(Pos.CENTER);

        VBox contenedorBotones = new VBox(20, botonesDecision, botonComenzarPartida);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.setPadding(new Insets(10));
        contenedorBotones.setSpacing(10);

        VBox layoutCentral = new VBox(40, titleBox, gridCartas, contenedorBotones);
        layoutCentral.setAlignment(Pos.CENTER);
        layoutCentral.setPadding(new Insets(20));


        root = new StackPane(background.getImageView(), layoutCentral);
    }

    private GridPane inicializarGridCartas(ControladorJuego controlador) {
        GridPane grid = new GridPane();
        grid.setHgap(30);
        grid.setVgap(30);
        grid.setAlignment(Pos.CENTER);

        List<Carta> cartasJugador = controlador.obtenerCartasJugador();
        int columnas = 5;

        for (int i = 0; i < cartasJugador.size(); i++) {
            Carta carta = cartasJugador.get(i);

            Image imagen = new Image(getClass().getResourceAsStream("/" + carta.getImage()));
            ImageView fondoCarta = new ImageView(imagen);
            fondoCarta.setFitWidth(100);
            fondoCarta.setFitHeight(130);
            fondoCarta.setPreserveRatio(false);

            Label nombre = new Label(carta.getFormatoCarta());
            nombre.setStyle("-fx-font-size: 10px; -fx-text-fill: #000000;");
            nombre.setWrapText(true);
            nombre.setMaxWidth(90);
            nombre.setAlignment(Pos.CENTER);


            VBox cartaVisual = new VBox(fondoCarta, nombre);
            cartaVisual.setAlignment(Pos.TOP_CENTER);
            cartaVisual.setSpacing(5);
            cartaVisual.setPrefSize(100, 200);
            cartaVisual.setStyle(
                    "-fx-background-color: white; " +
                            "-fx-background-size: cover;" +
                            "-fx-background-repeat: no-repeat;" +
                            "-fx-background-position: center;" +
                            "-fx-border-color: black;" +
                            "-fx-border-radius: 5px;" +
                            "-fx-background-radius: 5px;"
            );


            Tooltip tooltip = new Tooltip();
            tooltip.setText(carta.getDescripcion());
            tooltip.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
            tooltip.setMaxWidth(300);
            tooltip.setWrapText(true);

            Tooltip.install(fondoCarta, tooltip);


            final boolean[] tooltipVisible = {false};

            cartaVisual.setOnMouseClicked(e -> {
                if (tooltipVisible[0]) {
                    tooltip.hide();
                    tooltipVisible[0] = false;
                } else {
                    tooltip.show(cartaVisual, e.getScreenX(), e.getScreenY());
                    tooltipVisible[0] = true;
                }
            });

            int col = i % columnas;
            int row = i / columnas;
            grid.add(cartaVisual, col, row);
        }

        return grid;
    }

    private void actualizarGridCartas(GridPane grid, ControladorJuego controlador) {
        grid.getChildren().clear();
        List<Carta> cartasJugador = controlador.obtenerCartasJugador();
        int columnas = 5;

        for (int i = 0; i < cartasJugador.size(); i++) {
            Carta carta = cartasJugador.get(i);

            Image imagen = new Image(getClass().getResourceAsStream("/" + carta.getImage()));
            ImageView fondoCarta = new ImageView(imagen);
            fondoCarta.setFitWidth(100);
            fondoCarta.setFitHeight(130);
            fondoCarta.setPreserveRatio(false);

            Label nombre = new Label(carta.getFormatoCarta());
            nombre.setStyle("-fx-font-size: 10px; -fx-text-fill: #000000;");
            nombre.setWrapText(true);
            nombre.setMaxWidth(90);
            nombre.setAlignment(Pos.CENTER);

            VBox cartaVisual = new VBox(fondoCarta, nombre);

            cartaVisual.setAlignment(Pos.TOP_CENTER);
            cartaVisual.setSpacing(5);
            cartaVisual.setPrefSize(100, 200);
            cartaVisual.setStyle(
                    "-fx-border-color: black;" +
                            "-fx-background-color: white;" +
                            "-fx-border-radius: 5px;" +
                            "-fx-background-radius: 5px;"
            );

            Tooltip tooltip = new Tooltip();
            tooltip.setText(carta.getDescripcion());
            tooltip.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
            tooltip.setMaxWidth(300);
            tooltip.setWrapText(true);
            Tooltip.install(fondoCarta, tooltip);


            final boolean[] tooltipVisible = {false};

            cartaVisual.setOnMouseClicked(e -> {
                if (tooltipVisible[0]) {
                    tooltip.hide();
                    tooltipVisible[0] = false;
                } else {
                    tooltip.show(cartaVisual, e.getScreenX(), e.getScreenY());
                    tooltipVisible[0] = true;
                }
            });
            int col = i % columnas;
            int row = i / columnas;
            grid.add(cartaVisual, col, row);
            grid.setHgap(30);
            grid.setVgap(30);
        }
    }

    public StackPane getRoot() {
        return root;
    }
}

