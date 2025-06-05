package edu.fiuba.algo3.modelo;

public class Unidad implements Carta {
    private Seccion seccion;

    public Unidad() {}

    public Unidad (Seccion seccion) {
        this.seccion = seccion;
    }

    public void usar () {
        this.seccion.ubicar(this);
    }
}
