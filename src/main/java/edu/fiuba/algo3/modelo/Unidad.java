package edu.fiuba.algo3.modelo;

public class Unidad implements Carta {
    protected String tipo;
    protected Seccion seccion;
    private int puntos, puntosIniciales;

    public Unidad (Seccion seccion) {
        this.seccion = seccion;
    }

    public Unidad (Seccion seccion, String tipo) {
        this.seccion = seccion;
        this.tipo = tipo;
    }

    public Unidad (Seccion seccion, int puntos) {
        this.seccion = seccion;
        this.puntos = puntos;
        this.puntosIniciales = puntos;
    }

    public Unidad (String tipo, Seccion seccion, int puntos) {
        this.seccion = seccion;
        this.tipo = tipo;
        this.puntos = puntos;
        this.puntosIniciales = puntos;
    }

    public Unidad() {
    }

    public int calcularPuntaje(int acumulador){
        return acumulador + puntos;
    }

    public void usar () {
        this.seccion.ubicar(this);
        this.seccion.actualizarValores();
    }

    public int esDeTipo (String tipo) {
        return tipo.equals(this.tipo) ? 1 : 0;
    }

    public void congelarPuntaje() {
        this.puntos = 1;
    }

    public void modificarPuntaje(String tipo, int acumulador) {
        if (this.tipo.equals(tipo)) {
            this.puntos = acumulador * puntosIniciales;
        }
    }
}
