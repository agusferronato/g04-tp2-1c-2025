package edu.fiuba.algo3.vistas.components;

import edu.fiuba.algo3.controllers.ControladorJuego;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LayoutJuego {

    private List<Button> botonesJugador;

    private Label paseDeRondaJugador;
    private Label nombreJugadorLabel;
    private Label puntosJugadorLabel;
    private Label rondasJugadorLabel;

    private Label nombreEnemigoLabel;
    private Label puntosEnemigoLabel;
    private Label rondasEnemigoLabel;
    private Label paseDeRondaEnemigo;

    private StackPane anuncioStack;
    private Region overlay;

    private StackPane root;
    private BorderPane layoutPrincipal;
    private HBox zonaCartas;
    private ControladorJuego controlador;

    public LayoutJuego(Stage stage, ControladorJuego controlador) {
        botonesJugador = new ArrayList<>();
        anuncioStack = new StackPane();
        overlay = new Region();

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


    public void crearCentroTablero() {
        Pane tablero = new Pane();
        tablero.setPrefSize(800, 600);
        tablero.setStyle("-fx-background-color: #2e8b57; -fx-border-color: black;");

        List<Ubicable> secciones = new ArrayList<>(controlador.obtenerSecciones());
        Collections.reverse(secciones);

        int columnas = 3;
        int filas = 2;
        double anchoSeccion = 400;
        double altoSeccion = 320;
        double separacion = 10;

        for (int i = 0; i < secciones.size(); i++) {
            Ubicable seccion = secciones.get(i);

            String nombreSeccion = seccion.getNombre();

            VBox vistaSeccion = new VBox(5);
            vistaSeccion.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-border-color: white;");
            vistaSeccion.setPrefSize(anchoSeccion, altoSeccion);
            vistaSeccion.setAlignment(Pos.TOP_CENTER);

            int fila = i / columnas;
            int col = i % columnas;
            vistaSeccion.setLayoutX(col * (anchoSeccion + separacion));
            vistaSeccion.setLayoutY(fila * (altoSeccion + separacion));

            Label titulo = new Label(nombreSeccion);
            titulo.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: white;");
            vistaSeccion.getChildren().add(titulo);

            for (UnidadGeneral unidad : seccion.obtenerCartas()) {
                Label formato = new Label(unidad.getFormato());
                formato.setStyle("-fx-font-size: 12px; -fx-text-fill: red;");
                formato.setWrapText(true);

                VBox contenido = new VBox(formato);
                contenido.setAlignment(Pos.TOP_LEFT);
                contenido.setPrefSize(140, 200);
                contenido.setStyle("-fx-background-color: white; -fx-border-color: black;");

                vistaSeccion.getChildren().add(contenido);
            }

            tablero.getChildren().add(vistaSeccion);
        }


        layoutPrincipal.setCenter(tablero);
    }

    public void crearZonaMano () {
        zonaCartas = new HBox(10);
        zonaCartas.setAlignment(Pos.CENTER);
        zonaCartas.setPadding(new Insets(10));
        zonaCartas.setStyle("-fx-background-color: #eeeeee;");

        List<Carta> cartas = controlador.obtenerCartasJugador();

        for (Carta carta : cartas) {

            Label formato = new Label(carta.getFormato());
            formato.setStyle("-fx-font-size: 12px; -fx-text-fill: red;");
            formato.setWrapText(true);

            VBox contenido = new VBox(formato);
            contenido.setAlignment(Pos.TOP_LEFT);

            Button botonCarta = new Button();
            botonCarta.setStyle("-fx-background-color: white; -fx-border-color: black;");
            botonCarta.setGraphic(contenido);
            botonCarta.setPrefSize(140, 200);


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
        zonaCartas.getChildren().clear();
        crearZonaMano();
    }


    public StackPane getRoot() {
        return root;
    }

    public void crearInfoIzquierda() {
        Font font = Font.font(14);

        paseDeRondaJugador = new Label(controlador.jugadorPasoDeRonda());
        nombreJugadorLabel = new Label("Jugador: " + controlador.obtenerNombreJugador());
        puntosJugadorLabel = new Label("Puntos: " + controlador.obtenerPuntosJugador());
        rondasJugadorLabel = new Label("Rondas: " + controlador.obtenerRondasJugador());

        paseDeRondaEnemigo = new Label(controlador.enemigoPasoDeRonda());
        nombreEnemigoLabel = new Label("Enemigo: " + controlador.obtenerNombreAdversario());
        puntosEnemigoLabel = new Label("Puntos: " + controlador.obtenerPuntosAdversario());
        rondasEnemigoLabel = new Label("Rondas: " + controlador.obtenerRondasAdversario());

        for (Label label : new Label[]{paseDeRondaJugador, nombreJugadorLabel, puntosJugadorLabel, rondasJugadorLabel,
                paseDeRondaEnemigo, nombreEnemigoLabel, puntosEnemigoLabel, rondasEnemigoLabel}) {
            label.setFont(font);
        }

        VBox jugadorBox = new VBox(5, paseDeRondaJugador, nombreJugadorLabel, puntosJugadorLabel, rondasJugadorLabel);
        VBox enemigoBox = new VBox(5, paseDeRondaEnemigo, nombreEnemigoLabel, puntosEnemigoLabel, rondasEnemigoLabel);

        Label rondaActualLabel = new Label("Ronda actual: " + controlador.obtenerNumeroDeRonda());
        rondaActualLabel.setFont(font);

        VBox izquierda = new VBox(20, jugadorBox, enemigoBox, rondaActualLabel);

        izquierda.setPadding(new Insets(10));
        izquierda.setAlignment(Pos.TOP_LEFT);

        layoutPrincipal.setLeft(izquierda);
    }

    private void crearBotonDerecha() {
        Button botonPasar = new Button("Pasar");

        botonPasar.setOnAction(e -> {
           controlador.pasar();
        });

        botonesJugador.add(botonPasar);

        VBox box = new VBox(botonPasar);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);
        layoutPrincipal.setRight(box);
    }

    public void mostrarGanador(Jugador ganador) {
        // Crear un nuevo layout para la pantalla final
        VBox contenedorFinal = new VBox(20);
        contenedorFinal.setAlignment(Pos.CENTER);
        contenedorFinal.setPadding(new Insets(30));
        contenedorFinal.setStyle("-fx-background-color: linear-gradient(to bottom, #1e3c72, #2a5298);");

        Label titulo = new Label("Fin del juego");
        titulo.setFont(Font.font("Arial", 36));
        titulo.setTextFill(Color.WHITE);


        Label nombreGanador = new Label("Empate");

        if (ganador != null) {
            nombreGanador = new Label("Ganó: " + ganador.getNombre());

        }

        nombreGanador.setFont(Font.font("Arial", 28));
        nombreGanador.setTextFill(Color.GOLD);

        Button salir = new Button("Salir");
        salir.setOnAction(e -> {
            Stage stage = (Stage) contenedorFinal.getScene().getWindow();
            stage.close();
        });

        contenedorFinal.getChildren().addAll(titulo, nombreGanador, salir);

        Scene escenaGanador = new Scene(contenedorFinal, 600, 400);

        // Obtener el Stage actual
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(escenaGanador);
    }
}
