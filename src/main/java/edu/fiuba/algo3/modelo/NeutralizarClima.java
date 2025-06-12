package edu.fiuba.algo3.modelo;

public class NeutralizarClima extends Especial {
    private Seccion seccion;

    public NeutralizarClima(Seccion seccion) {
        this.seccion = seccion;
    }

    @Override
    public void usar(Jugador jugador) {
        seccion.reestablecerPuntajeCartas();
    }
}
