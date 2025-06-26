package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.ControladorJuego;
import edu.fiuba.algo3.vistas.components.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        PlayButton playButton = new PlayButton(e -> crearJugador(stage));
        LayoutStart mainLayout = new LayoutStart(stage, playButton);
        Scene scene = new Scene(mainLayout.getRoot(), 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }


    public void crearJugador(Stage stage) {
        ControladorJuego controladorJuego = new ControladorJuego();
        SubmitButton submitButton = new SubmitButton(e-> { comenzarJuego(stage, controladorJuego); });
        LayoutPlayer mainLayout = new LayoutPlayer(stage, submitButton, controladorJuego);
        Scene scene = new Scene(mainLayout.getRoot(), 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    /*
    public void elegirMazo(Stage stage){
        LayoutMazos mainLayout = new LayoutMazos(stage);
        Scene scene = new Scene(mainLayout.getRoot(), 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    } */


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