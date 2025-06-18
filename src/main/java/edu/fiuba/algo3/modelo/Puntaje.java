package edu.fiuba.algo3.modelo;

public class Puntaje {
    private int puntajeBase;
    private int puntajeModificadores;
    private int puntajeActual;

    public Puntaje(int puntajeBase) {
        this.puntajeBase = puntajeBase;
        this.puntajeActual = puntajeBase;
        this.puntajeModificadores = puntajeBase;
    }

    public void aplicarClima() {
        puntajeActual = 1;
    }


    public void restablecerAValorModificadores() {
        puntajeActual = puntajeModificadores;
    }

    public void modificarPuntaje(int acumulador) {
        puntajeActual = puntajeBase * acumulador;
        puntajeModificadores = puntajeBase * acumulador;
    }

    public int calcularPuntaje(int acumulador) {
        return puntajeActual + acumulador;
    }

    public boolean superaPuntaje(int puntaje) {
        return puntajeActual >= puntaje;
    }

    public int devolverPuntajeSiSupera(int puntaje) {
        return Math.max(this.puntajeActual, puntaje);
    }
}
