package edu.fiuba.algo3.vistas.Sonido;

import javafx.scene.media.AudioClip;

public class SonidoSeleccion {
    private static final AudioClip efecto = new AudioClip(SonidoSeleccion.class.getResource("/sounds/seleccion.mp3").toString());

    private SonidoSeleccion () {}

    public static void ejecutarSonido() {
        efecto.play();
    }
}