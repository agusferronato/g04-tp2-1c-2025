package edu.fiuba.algo3.modelo;

public class Unidad implements Carta {
    private Seccion seccion;
    private int puntos;
    private Unida modificador;

    public Unidad (Seccion seccion) {
        this.seccion = seccion;
    }

    public Unidad (Seccion seccion, int puntos) {
        this.seccion = seccion;
        this.puntos = puntos;
    }

    public Unidad() {
    }

    public Unidad(Unida modificador, Seccion seccion, int puntajeCartas) {
        this.seccion = seccion;
        this.puntos = puntajeCartas;
        this.modificador = modificador;
    }

    public int calcularPuntaje(int acumulador){
        return acumulador + puntos;
    }

    public void usar () {
        this.seccion.ubicar(this);
    }
}
