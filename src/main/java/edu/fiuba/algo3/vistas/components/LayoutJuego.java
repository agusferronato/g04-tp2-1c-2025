package edu.fiuba.algo3.vistas.components;

import edu.fiuba.algo3.controllers.ControladorJuego;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LayoutJuego {

    private Label nombreJugadorLabel;
    private Label puntosJugadorLabel;
    private Label rondasJugadorLabel;

    private Label nombreEnemigoLabel;
    private Label puntosEnemigoLabel;
    private Label rondasEnemigoLabel;

    private StackPane root;
    private BorderPane layoutPrincipal;
    private HBox zonaCartas;
    private ControladorJuego controlador;

    public LayoutJuego(Stage stage, ControladorJuego controlador) {
        this.controlador = controlador;
        stage.setTitle("Juego");

        root = new StackPane();
        layoutPrincipal = new BorderPane();
        root.getChildren().add(layoutPrincipal);

        crearCentroTablero();
        crearZonaMano();
        crearInfoIzquierda();
        crearBotonDerecha();
    }



    public void crearCentroTablero() {
        int columnas = 3;
        int filas = 2;
        double separacion = 40;
        GridPane tablero = new GridPane();
        tablero.setGridLinesVisible(false);
        tablero.setPadding(new Insets(separacion));
        tablero.setHgap(separacion);
        tablero.setVgap(separacion);

        tablero.setStyle(
                "-fx-border-color: #3a2718; -fx-border-width: 8px; " +
                        "-fx-background-image: url('" + getClass().getResource("/imagenes/txmadera2.jpg").toString() + "');" +
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
        Collections.reverse(secciones); // si querés invertir el orden

        for (int i = 0; i < secciones.size(); i++) {
            Ubicable seccion = secciones.get(i);

            VBox vistaSeccion = new VBox(5);
            vistaSeccion.setStyle("-fx-background-color: rgba(255,255,255,0.1); -fx-border-color: white;"+
                    "-fx-background-image: url('" + getClass().getResource("/imagenes/fondosecciones.jpg").toString() + "');" +
                    "-fx-background-size: cover; " );
            vistaSeccion.setAlignment(Pos.TOP_CENTER);
            vistaSeccion.setPadding(new Insets(10));
            vistaSeccion.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

            Label titulo = new Label(seccion.getNombre());
            titulo.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: white;");
            vistaSeccion.getChildren().add(titulo);

            for (UnidadGeneral unidad : seccion.obtenerCartas()) {
                Label formato = new Label(unidad.getFormato());
                formato.setStyle("-fx-font-size: 12px; -fx-text-fill: red;");
                formato.setWrapText(true);

                VBox carta = new VBox(formato);
                carta.setStyle("-fx-background-color: white; -fx-border-color: black;");
                carta.setPrefSize(140, 200);
                carta.setAlignment(Pos.TOP_LEFT);

                vistaSeccion.getChildren().add(carta);
            }

            int fila = i / columnas;
            int col = i % columnas;
            tablero.add(vistaSeccion, col, fila);
            GridPane.setHgrow(vistaSeccion, Priority.ALWAYS);
            GridPane.setVgrow(vistaSeccion, Priority.ALWAYS);
        }

        layoutPrincipal.setCenter(tablero);
    }


    public void crearZonaMano () {
        zonaCartas = new HBox(10);
        zonaCartas.setAlignment(Pos.CENTER);
        zonaCartas.setPadding(new Insets(10));
        zonaCartas.setStyle("-fx-background-color: #2c0808;");

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
                /* Logica de seleccion */
                botonCarta.setDisable(true);
                controlador.jugar(carta);
                crearCentroTablero();
                actualizarZonaMano();
            });

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

    private void crearInfoIzquierda() {
        Font font = Font.font(14);

        nombreJugadorLabel = new Label("Jugador: " + controlador.obtenerNombreJugador());
        puntosJugadorLabel = new Label("Puntos: 0");
        rondasJugadorLabel = new Label("Rondas: 0");

        nombreEnemigoLabel = new Label("Enemigo: " + controlador.obtenerNombreAdversario());
        puntosEnemigoLabel = new Label("Puntos enemigo: 0");
        rondasEnemigoLabel = new Label("Rondas enemigo: 0");

        for (Label label : new Label[]{nombreJugadorLabel, puntosJugadorLabel, rondasJugadorLabel,
                nombreEnemigoLabel, puntosEnemigoLabel, rondasEnemigoLabel}) {
            label.setFont(font);
        }

        VBox jugadorBox = new VBox(5, nombreJugadorLabel, puntosJugadorLabel, rondasJugadorLabel);
        VBox enemigoBox = new VBox(5, nombreEnemigoLabel, puntosEnemigoLabel, rondasEnemigoLabel);

        VBox izquierda = new VBox(20, jugadorBox, enemigoBox);
        izquierda.setStyle("-fx-background-color: #2c0808;");
        izquierda.setPadding(new Insets(10));
        izquierda.setPrefWidth(200);
        izquierda.setAlignment(Pos.TOP_LEFT);
        layoutPrincipal.setLeft(izquierda);
    }

    private void crearBotonDerecha() {
        Button botonPasar = new Button("Pasar");
        VBox box = new VBox(botonPasar);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);
        layoutPrincipal.setRight(box);
    }

}


/*
private BorderPane layoutPrincipal;

private Pane tablero;
private HBox zonaCartas;
private Button botonPasar;

private Label nombreJugadorLabel;
private Label puntosJugadorLabel;
private Label rondasJugadorLabel;

private Label nombreEnemigoLabel;
private Label puntosEnemigoLabel;
private Label rondasEnemigoLabel;

public LayoutJuego(Stage stage, ControladorJuego controlador) {
    this.controlador = controlador;
    stage.setTitle("Juego");
    root = new StackPane();

    layoutPrincipal = new BorderPane();
    root.getChildren().add(layoutPrincipal);

    crearCentroTablero();
    crearZonaCartas();
    crearBotonDerecha();
    crearInfoIzquierda();
}

private void crearCentroTablero() {
    tablero = new Pane();
    tablero.setPrefSize(500, 400);
    tablero.setStyle("-fx-background-color: #2e8b57; -fx-border-color: black;");
    layoutPrincipal.setCenter(tablero);
}

private void crearZonaCartas() {
    zonaCartas = new HBox(10);
    zonaCartas.setAlignment(Pos.CENTER);
    zonaCartas.setPadding(new Insets(10));
    zonaCartas.setStyle("-fx-background-color: #eeeeee;");

    // Ejemplo de 5 cartas ficticias
    for (int i = 1; i <= 5; i++) {
        Label carta = new Label("Carta " + i);
        carta.setStyle("-fx-border-color: black; -fx-padding: 10px;");
        zonaCartas.getChildren().add(carta);
    }

    layoutPrincipal.setBottom(zonaCartas);
}

private void crearBotonDerecha() {
    botonPasar = new Button("Pasar turno");
    VBox box = new VBox(botonPasar);
    box.setPadding(new Insets(10));
    box.setAlignment(Pos.CENTER);
    layoutPrincipal.setRight(box);
}

private void crearInfoIzquierda() {
    Font font = Font.font(14);

    nombreJugadorLabel = new Label("Jugador: Tú");
    puntosJugadorLabel = new Label("Puntos: 0");
    rondasJugadorLabel = new Label("Rondas: 0");

    nombreEnemigoLabel = new Label("Enemigo: CPU");
    puntosEnemigoLabel = new Label("Puntos enemigo: 0");
    rondasEnemigoLabel = new Label("Rondas enemigo: 0");

    for (Label label : new Label[]{nombreJugadorLabel, puntosJugadorLabel, rondasJugadorLabel,
            nombreEnemigoLabel, puntosEnemigoLabel, rondasEnemigoLabel}) {
        label.setFont(font);
    }

    VBox jugadorBox = new VBox(5, nombreJugadorLabel, puntosJugadorLabel, rondasJugadorLabel);
    VBox enemigoBox = new VBox(5, nombreEnemigoLabel, puntosEnemigoLabel, rondasEnemigoLabel);

    VBox izquierda = new VBox(20, jugadorBox, enemigoBox);
    izquierda.setPadding(new Insets(10));
    izquierda.setAlignment(Pos.TOP_LEFT);

    layoutPrincipal.setLeft(izquierda);
}

// Getter principal
public StackPane getRoot() {
    return root;
}

// Getters para el controlador
public Button getBotonPasar() {
    return botonPasar;
}

public Pane getTablero() {
    return tablero;
}

public HBox getZonaCartas() {
    return zonaCartas;
}

// Métodos para actualizar info en pantalla
public void actualizarNombreJugador(String nombre) {
    nombreJugadorLabel.setText("Jugador: " + nombre);
}

public void actualizarPuntosJugador(int puntos) {
    puntosJugadorLabel.setText("Puntos: " + puntos);
}

public void actualizarRondasJugador(int rondas) {
    rondasJugadorLabel.setText("Rondas: " + rondas);
}

public void actualizarNombreEnemigo(String nombre) {
    nombreEnemigoLabel.setText("Enemigo: " + nombre);
}

public void actualizarPuntosEnemigo(int puntos) {
    puntosEnemigoLabel.setText("Puntos enemigo: " + puntos);
}

public void actualizarRondasEnemigo(int rondas) {
    rondasEnemigoLabel.setText("Rondas enemigo: " + rondas);
}
}


 */