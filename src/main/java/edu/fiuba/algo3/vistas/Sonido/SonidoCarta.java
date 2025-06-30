package edu.fiuba.algo3.vistas.Sonido;

import javafx.scene.media.AudioClip;

public class SonidoCarta {
    private static final AudioClip efecto = new AudioClip(SonidoCarta.class.getResource("/sounds/sonido-carta.mp3").toString());

    private SonidoCarta () {} // Singleton

    public static void ejecutarSonidoCarta () {
        efecto.play();
    }

}