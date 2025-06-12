package edu.fiuba.algo3.modelo;

public class Unida extends Unidad {
    private Unidad carta;
    private String tipo;
    private Seccion seccion;

    public Unida (Unidad carta, Seccion seccion, String tipo) {
        this.carta = carta;
        this.seccion = seccion;
        this.tipo = tipo;
    }

    public void usar (Jugador jugador) {
        this.seccion.setStrategy(new Duplicador(tipo));
        this.carta.usar(jugador);
    }
}
