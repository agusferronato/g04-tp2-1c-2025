package edu.fiuba.algo3.modelo;

public class Unida extends Unidad {
    private Unidad carta;

    public Unida (Unidad carta, Seccion seccion, String tipo, int puntos) {
        super(tipo, seccion, puntos);
        this.carta = carta;
    }

    public void usar () {
        this.seccion.setStrategy(new Duplicador(tipo));
        super.usar();
    }
}
