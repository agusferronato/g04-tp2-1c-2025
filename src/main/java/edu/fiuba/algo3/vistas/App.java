package edu.fiuba.algo3.vistas;

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


    public void crearJugador(Stage stage){
        SubmitButton submitButton = new SubmitButton(e-> elegirMazo(stage));
        LayoutPlayer mainLayout = new LayoutPlayer(stage, submitButton);
        Scene scene = new Scene(mainLayout.getRoot(), 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    public void elegirMazo(Stage stage){
        LayoutMazos mainLayout = new LayoutMazos(stage);
        Scene scene = new Scene(mainLayout.getRoot(), 800, 600);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}