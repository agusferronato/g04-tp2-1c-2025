package edu.fiuba.algo3.vistas.components;

import edu.fiuba.algo3.controllers.ControladorJuego;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LayoutJuego {

    private StackPane anuncioStack;
    private Region overlay;
    private List<Button> botonesJugador;

    private Label pasoJugadorLabel;
    private Label nombreJugadorLabel;
    private Label puntosJugadorLabel;
    private Label rondasJugadorLabel;

    private Label pasoEnemigoLabel;
    private Label nombreEnemigoLabel;
    private Label puntosEnemigoLabel;
    private Label rondasEnemigoLabel;

    private StackPane root;
    private BorderPane layoutPrincipal;
    private HBox zonaCartas;
    private ControladorJuego controlador;

    public LayoutJuego(Stage stage, ControladorJuego controlador) {
        anuncioStack = new StackPane();
        overlay = new Region();
        botonesJugador = new ArrayList<>();

        root = new StackPane();

        overlay = new Region();
        overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
        overlay.prefWidthProperty().bind(root.widthProperty());
        overlay.prefHeightProperty().bind(root.heightProperty());
        overlay.setVisible(false);
        overlay.setMouseTransparent(true);

        anuncioStack = new StackPane();
        anuncioStack.setPickOnBounds(false);
        anuncioStack.setMouseTransparent(true);
        anuncioStack.setVisible(false);


        stage.setTitle("Juego");

        layoutPrincipal = new BorderPane();
        root.getChildren().addAll(layoutPrincipal, overlay, anuncioStack);

        root.setStyle("-fx-background-image: url('" + getClass().getResource("/imagenes/txmadera2.jpg").toString() + "');" +
                "-fx-background-size: cover;");

        this.controlador = controlador;
        controlador.setVista(this);

        crearCentroTablero();
        crearZonaMano();
        crearInfoIzquierda();
        crearBotonDerecha();

        controlador.iniciarJuego();
        mostrarAnuncio("Empieza: " + controlador.turnoActual());

        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(e -> {
            controlador.simularSiEsTurnoDeAdversario();
        });

        pause.play();
    }



    public void crearCentroTablero() {
        int columnas = 3;
        int filas = 2;
        double separacion = 20;
        GridPane tablero = new GridPane();
        tablero.setGridLinesVisible(false);
        tablero.setPadding(new Insets(separacion));
        tablero.setHgap(separacion);
        tablero.setVgap(separacion);

        tablero.setStyle(
                "-fx-border-color: #3a2718; -fx-border-width: 8px; " +
                        "-fx-background-image: url('" + getClass().getResource("/imagenes/txmadera2.jpg") + "');" +
                        "-fx-background-size: cover; " +
                        "-fx-effect: innershadow(three-pass-box, rgba(0,0,0,0.6), 15, 0, 0, 0);"
        );

        for (int i = 0; i < columnas; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0 / columnas);
            col.setHgrow(Priority.ALWAYS);
            tablero.getColumnConstraints().add(col);
        }
        for (int i = 0; i < filas; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / filas);
            row.setVgrow(Priority.ALWAYS);
            tablero.getRowConstraints().add(row);
        }

        List<Ubicable> secciones = new ArrayList<>(controlador.obtenerSecciones());
        Collections.reverse(secciones);

        for (int i = 0; i < secciones.size(); i++) {
            Ubicable seccion = secciones.get(i);

            VBox vistaSeccion = new VBox(5);
            vistaSeccion.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-border-color: white;" +
                    "-fx-background-image: url('" + getClass().getResource("/imagenes/fondosecciones.jpg") + "');" +
                    "-fx-background-size: cover;");
            vistaSeccion.setAlignment(Pos.TOP_CENTER);
            vistaSeccion.setPadding(new Insets(10));
            vistaSeccion.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

            Label titulo = new Label(seccion.getNombre());
            titulo.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: white;");
            vistaSeccion.getChildren().add(titulo);

            GridPane grillaCartas = new GridPane();
            grillaCartas.setHgap(10);
            grillaCartas.setVgap(10);

            int cartasPorFila = 3;
            List<UnidadGeneral> cartas = seccion.obtenerCartas();
            for (int j = 0; j < cartas.size(); j++) {
                UnidadGeneral unidad = cartas.get(j);

                // Fondo visual
                Image imagen = new Image(getClass().getResourceAsStream("/" + unidad.getImage()));
                ImageView fondoCarta = new ImageView(imagen);
                fondoCarta.setFitWidth(90);
                fondoCarta.setFitHeight(130);
                fondoCarta.setPreserveRatio(false);

                // Nombre
                Label nombre = new Label(unidad.getNombre());
                nombre.setStyle("-fx-font-size: 10px; -fx-text-fill: white;");
                nombre.setWrapText(true);
                nombre.setMaxWidth(80);
                nombre.setAlignment(Pos.CENTER);

                // Puntaje
                Label puntaje = new Label("Puntos: " + unidad.calcularPuntaje(0));
                puntaje.setStyle("-fx-font-size: 9px; -fx-text-fill: white;");
                puntaje.setAlignment(Pos.CENTER);

                VBox textoCarta = new VBox(nombre, puntaje);
                textoCarta.setAlignment(Pos.BOTTOM_CENTER);
                textoCarta.setSpacing(2);
                textoCarta.setPadding(new Insets(5));
                textoCarta.setStyle("-fx-background-color: rgba(0,0,0,0.4);");

                StackPane carta = new StackPane(fondoCarta, textoCarta);
                carta.setPrefSize(90, 130);
                carta.setStyle("-fx-border-color: black; -fx-border-radius: 5px; -fx-background-radius: 5px;");
                StackPane.setAlignment(textoCarta, Pos.BOTTOM_CENTER);

                int filaCarta = j / cartasPorFila;
                int colCarta = j % cartasPorFila;
                grillaCartas.add(carta, colCarta, filaCarta);
            }

            vistaSeccion.getChildren().add(grillaCartas);

            int fila = i / columnas;
            int col = i % columnas;
            tablero.add(vistaSeccion, col, fila);
            GridPane.setHgrow(vistaSeccion, Priority.ALWAYS);
            GridPane.setVgrow(vistaSeccion, Priority.ALWAYS);
        }

        layoutPrincipal.setCenter(tablero);
    }



    public void crearZonaMano() {
        zonaCartas = new HBox(10);
        zonaCartas.setAlignment(Pos.CENTER);
        zonaCartas.setPadding(new Insets(10));

        List<Carta> cartas = controlador.obtenerCartasJugador();

        for (Carta carta : cartas) {
            // Imagen de fondo
            Image imagen = new Image(getClass().getResourceAsStream("/" + carta.getImage()));
            ImageView fondoCarta = new ImageView(imagen);
            fondoCarta.setFitWidth(90);
            fondoCarta.setFitHeight(130);
            fondoCarta.setPreserveRatio(false);

            // Texto: nombre y puntaje
            Label nombre = new Label(carta.getFormatoCarta());
            nombre.setStyle("-fx-font-size: 10px; -fx-text-fill: white;");
            nombre.setWrapText(true);
            nombre.setMaxWidth(80);
            nombre.setAlignment(Pos.CENTER);


            VBox textoCarta = new VBox(nombre);
            textoCarta.setAlignment(Pos.BOTTOM_CENTER);
            textoCarta.setSpacing(2);
            textoCarta.setPadding(new Insets(5));
            textoCarta.setStyle("-fx-background-color: rgba(0,0,0,0.4);");

            // Apilar imagen y texto
            StackPane contenido = new StackPane(fondoCarta, textoCarta);
            contenido.setPrefSize(90, 130);
            StackPane.setAlignment(textoCarta, Pos.BOTTOM_CENTER);

            // Botón
            Button botonCarta = new Button();
            botonCarta.setGraphic(contenido);
            botonCarta.setPrefSize(90, 130);
            botonCarta.setStyle("-fx-background-color: transparent; -fx-padding: 0;");

            botonCarta.setOnAction(e -> {
                botonCarta.setDisable(true);
                controlador.jugar(carta);
            });

            botonesJugador.add(botonCarta);
            zonaCartas.getChildren().add(botonCarta);
        }

        layoutPrincipal.setBottom(zonaCartas);
    }



    public void actualizarZonaMano () {
        zonaCartas = new HBox(10);
        crearZonaMano();
    }


    public StackPane getRoot() {
        return root;
    }

    public void crearInfoIzquierda() {
        Font cardinalFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Cardinal.ttf"), 30);

        pasoJugadorLabel = new Label(controlador.jugadorPasoDeRonda());
        nombreJugadorLabel = new Label("Jugador: " + controlador.obtenerNombreJugador());
        puntosJugadorLabel = new Label("Puntos: " + controlador.obtenerPuntosJugador());
        rondasJugadorLabel = new Label("Rondas: " + controlador.obtenerRondasJugador());

        pasoEnemigoLabel = new Label(controlador.enemigoPasoDeRonda());
        nombreEnemigoLabel = new Label("Enemigo: " + controlador.obtenerNombreAdversario());
        puntosEnemigoLabel = new Label("Puntos enemigo: " + controlador.obtenerPuntosAdversario());
        rondasEnemigoLabel = new Label("Rondas enemigo: " + controlador.obtenerRondasAdversario());

        for (Label label : new Label[]{pasoJugadorLabel, nombreJugadorLabel, puntosJugadorLabel, rondasJugadorLabel,
                pasoEnemigoLabel, nombreEnemigoLabel, puntosEnemigoLabel, rondasEnemigoLabel}) {
            label.setFont(cardinalFont);
            label.setTextFill(Color.GOLD);
        }

        VBox jugadorBox = new VBox(5, pasoJugadorLabel, nombreJugadorLabel, puntosJugadorLabel, rondasJugadorLabel);
        VBox enemigoBox = new VBox(5, pasoEnemigoLabel, nombreEnemigoLabel, puntosEnemigoLabel, rondasEnemigoLabel);

        Label rondaActualLabel = new Label("Ronda actual: " + controlador.obtenerNumeroDeRonda());
        rondaActualLabel.setFont(cardinalFont);

        jugadorBox.setAlignment(Pos.BOTTOM_LEFT);
        enemigoBox.setAlignment(Pos.TOP_LEFT);

        BorderPane contenedor = new BorderPane();
        contenedor.setPadding(new Insets(10));
        contenedor.setPrefWidth(250);

        BorderPane.setMargin(enemigoBox, new Insets(60, 0, 0, 0)); //
        BorderPane.setMargin(jugadorBox, new Insets(0, 0, 60, 0)); //

        contenedor.setTop(enemigoBox);
        contenedor.setBottom(jugadorBox);

        layoutPrincipal.setLeft(contenedor);
    }


    public void deshabilitarBotones () {
        for (Button boton : botonesJugador) {
            boton.setDisable(true);
        }
    }

    public void habilitarBotones () {
        for (Button boton : botonesJugador) {
            boton.setDisable(false);
        }
    }

    private void crearBotonDerecha() {
        Button button = new Button("Pasar");
        Font cardinalFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Cardinal.ttf"), 40);
        button.setFont(cardinalFont);
        button.setPrefSize(250, 100);
        button.setStyle(
                "-fx-background-color: #ffcc00; " +
                        "-fx-background-radius: 25px; " +
                        "-fx-padding: 10 10 10 10; " +
                        "-fx-background-insets: 0;"
        );
        button.setCursor(Cursor.HAND);
        DropShadow outerGlow = new DropShadow();
        outerGlow.setColor(Color.web("#ffffaa"));
        outerGlow.setRadius(30);
        outerGlow.setSpread(0.6);

        button.setOnAction(e -> {
            controlador.pasar();
        });

        botonesJugador.add(button);

        InnerShadow innerGlow = new InnerShadow();
        innerGlow.setColor(Color.web("#ffffaa"));
        innerGlow.setRadius(20);
        innerGlow.setChoke(0.3);
        innerGlow.setInput(outerGlow);

        button.setOnMouseEntered(e -> button.setEffect(innerGlow));
        button.setOnMouseExited(e -> button.setEffect(null));
        VBox box = new VBox(button);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);
        box.setPrefWidth(250);
        layoutPrincipal.setRight(box);
    }


    public void mostrarGanador(Jugador ganador) {
        Font cardinalFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Cardinal.ttf"), 100);
        Font buttonCardinalFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Cardinal.ttf"), 35);
        VBox contenedorFinal = new VBox(20);
        contenedorFinal.setAlignment(Pos.CENTER);
        contenedorFinal.setPadding(new Insets(30));


        Label titulo = new Label("Fin del juego");
        titulo.setFont(cardinalFont);
        titulo.setTextFill(Color.GOLD);

        Label nombreGanador = new Label("Empate");
        if (ganador != null) {
            nombreGanador = new Label("Ganó: " + ganador.getNombre());
        }
        nombreGanador.setFont(cardinalFont);
        nombreGanador.setTextFill(Color.GOLD);

        VBox contenedorGanador = new VBox(20);
        contenedorGanador.setAlignment(Pos.TOP_CENTER);
        contenedorGanador.setPadding(new Insets(10));
        contenedorGanador.getChildren().addAll(titulo, nombreGanador);

        Button salir = new Button("Salir");
        salir.setOnAction(e -> {
            Stage stage = (Stage) contenedorFinal.getScene().getWindow();
            stage.close();
        });
        salir.setFont(buttonCardinalFont);
        salir.setPrefSize(250, 100);
        salir.setStyle(
                "-fx-background-color: #ffcc00; " +
                        "-fx-background-radius: 25px; " +
                        "-fx-padding: 10 10  10; " +
                        "-fx-background-insets: 0;"
        );
        salir.setCursor(Cursor.HAND);

        DropShadow outerGlow = new DropShadow();
        outerGlow.setColor(Color.web("#ffffaa"));
        outerGlow.setRadius(30);
        outerGlow.setSpread(0.6);

        InnerShadow innerGlow = new InnerShadow();
        innerGlow.setColor(Color.web("#ffffaa"));
        innerGlow.setRadius(20);
        innerGlow.setChoke(0.3);
        innerGlow.setInput(outerGlow);

        salir.setOnMouseEntered(e -> salir.setEffect(innerGlow));
        salir.setOnMouseExited(e -> salir.setEffect(null));

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(salir);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        VBox.setVgrow(contenedorGanador, Priority.ALWAYS);

        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        contenedorFinal.getChildren().addAll(contenedorGanador, buttonBox);
        contenedorFinal.setPadding(new Insets(30, 30, 50, 30));

        Stage stage = (Stage) root.getScene().getWindow();
        BackgroundImage fondo = new BackgroundImage(stage, "/imagenes/FondoResultado.jpg");

        StackPane rootFondo = new StackPane();
        rootFondo.getChildren().addAll(fondo.getImageView(), contenedorFinal);

        Scene escenaGanador = new Scene(rootFondo, 600, 400);
        stage.setScene(escenaGanador);
        stage.setFullScreen(true);
    }


    public void mostrarAnuncio(String mensaje) {
        Label anuncio = new Label(mensaje);
        anuncio.setFont(Font.font(24));
        anuncio.setTextFill(Color.WHITE);
        anuncio.setStyle("-fx-background-color: rgba(0, 0, 0, 0.8); -fx-padding: 20px;");
        StackPane.setAlignment(anuncio, Pos.CENTER);

        anuncioStack.getChildren().setAll(anuncio);
        anuncioStack.setVisible(true);
        anuncioStack.setMouseTransparent(false);

        overlay.setVisible(true);
        overlay.setMouseTransparent(false);

        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(e -> ocultarAnuncio());
        pause.play();
    }

    private void ocultarAnuncio() {
        anuncioStack.getChildren().clear();
        overlay.setVisible(false);
        overlay.setMouseTransparent(true);
    }

}