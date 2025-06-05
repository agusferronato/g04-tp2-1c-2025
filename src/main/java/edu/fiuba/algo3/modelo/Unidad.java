package edu.fiuba.algo3.modelo;

public class Unidad implements Carta {
    private Seccion seccion;
    private int puntos;

    public Unidad() {}

    public Unidad (Seccion seccion) {
        this.seccion = seccion;
    }

    public Unidad (Seccion seccion, int puntos) {
        this.seccion = seccion;
        this.puntos = puntos;
    }

    public int calcularPuntaje(int acumulador){
        return acumulador + puntos;
    }

    public void usar () {
        this.seccion.ubicar(this);
    }
}
