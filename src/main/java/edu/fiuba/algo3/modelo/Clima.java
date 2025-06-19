package edu.fiuba.algo3.modelo;

public class Clima implements Especial {
    private Seccion seccion;

    public Clima(Seccion seccion) {
        this.seccion = seccion;
    }

    public void usar (Jugador jugador) {
        CreadorCongelar creador = new CreadorCongelar();
        this.seccion.agregarCartasA(creador);
        this.seccion.agregarComando(creador);
        this.seccion.actualizarValores();
    }

}
