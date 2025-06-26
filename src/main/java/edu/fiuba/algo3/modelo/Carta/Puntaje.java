package edu.fiuba.algo3.modelo.Carta;

public class Puntaje {
    private int puntajeBase;
    private int puntajeActual;

    public Puntaje(int puntajeBase) {
        this.puntajeBase = puntajeBase;
        this.puntajeActual = puntajeBase;
    }

    public void modificarPuntaje(int acumulador) {
        puntajeActual = puntajeBase * acumulador;
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

    public int devolverPuntajeBase() {
        return puntajeBase;
    }

    public void congelarPuntaje() {
        this.puntajeActual = 1;
    }

    public void duplicarPuntaje() {
        this.puntajeActual *= 2;
    }

    public void aumentarPuntaje() {
        puntajeActual++;
    }

    public void reiniciarPuntaje() {
        this.puntajeActual = puntajeBase;
    }
}
