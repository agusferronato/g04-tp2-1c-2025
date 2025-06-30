package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.ControladorJuego;
import edu.fiuba.algo3.vistas.Sonido.SonidoSeleccion;
import edu.fiuba.algo3.vistas.components.*;
import edu.fiuba.algo3.vistas.Sonido.SonidoAmbiente;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        PlayButton playButton = new PlayButton(e -> {
            SonidoSeleccion.ejecutarSonido();
            crearJugador(stage);
        });
        LayoutStart mainLayout = new LayoutStart(stage, playButton);
        Scene scene = new Scene(mainLayout.getRoot(), 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        SonidoAmbiente.iniciar();
        stage.show();
    }


    public void crearJugador(Stage stage) {
        ControladorJuego controladorJuego = new ControladorJuego();
        SubmitButton submitButton = new SubmitButton(e-> {
            SonidoSeleccion.ejecutarSonido();
            elegirMazo(stage, controladorJuego);
        });
        LayoutPlayer mainLayout = new LayoutPlayer(stage, submitButton, controladorJuego);
        Scene scene = new Scene(mainLayout.getRoot(), 800, 600);
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.show();
    }


    public void elegirMazo(Stage stage, ControladorJuego controladorJuego) {
        SubmitButton submitButton = new SubmitButton(e->{
            SonidoSeleccion.ejecutarSonido();
            comenzarJuego(stage, controladorJuego);
        });
        LayoutMazos mainLayout = new LayoutMazos(stage, submitButton, controladorJuego);
        Scene scene = new Scene(mainLayout.getRoot(), 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }


    public void comenzarJuego (Stage stage, ControladorJuego controlador) {
        LayoutJuego layoutJuego = new LayoutJuego(stage, controlador);
        controlador.setVista(layoutJuego);
        Scene scene = new Scene(layoutJuego.getRoot(), 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}