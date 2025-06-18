package edu.fiuba.algo3.modelo;

public class Unida extends Unidad {
    private Unidad carta;
    private String tipo;
    private CuerpoACuerpo seccion;

    public Unida (Unidad carta, CuerpoACuerpo seccion, String tipo) {
        this.carta = carta;
        this.seccion = seccion;
        this.tipo = tipo;
    }

    public void usar (Jugador jugador) {
        Duplicador duplicador = new Duplicador(tipo);
        seccion.setStrategy(duplicador);
        this.carta.usar(jugador);
    }
}
