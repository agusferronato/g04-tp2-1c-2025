package edu.fiuba.algo3.modelo;

public class Unidad implements Carta {
    private Seccion seccion;
    private int puntos;

    public Unidad() {}

    public Unidad (Seccion seccion, int puntos) {

        this.seccion = seccion;
        this.puntos = puntos;
    }

    public void usar () {
        seccion.colocarCarta(this);
    }

    public int calcularPuntaje(int puntos_entrantes){
        return (puntos_entrantes + this.puntos);
    }
}
