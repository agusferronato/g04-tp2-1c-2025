package edu.fiuba.algo3.vistas.Sonido;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SonidoAmbiente {
    private static MediaPlayer mediaPlayer;

    private SonidoAmbiente () {} // Singleton

    public static void iniciar() {
        if (mediaPlayer == null) {
            Media media = new Media(SonidoAmbiente.class.getResource("/sounds/musica.mp3").toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        }
    }
}
