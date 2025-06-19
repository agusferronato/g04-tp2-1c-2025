package edu.fiuba.algo3.modelo;

public class MoraleBoost implements Especial {
    private Seccion seccion;

    public MoraleBoost(Seccion seccion) {
        this.seccion = seccion;
    }

    public void usar (Jugador jugador) {
        CreadorComandoMoraleBoost creador = new CreadorComandoMoraleBoost();
        seccion.agregarCartasA(creador);
        seccion.agregarComando(creador);
        seccion.actualizarValores();
    }

}
