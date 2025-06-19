package edu.fiuba.algo3.modelo;

public class Unidad implements Carta {
    protected String tipo;
    protected CuerpoACuerpo seccion;
    private Puntaje puntaje;

    public Unidad (CuerpoACuerpo seccion) {
        this.seccion = seccion;
    }

    public Unidad (CuerpoACuerpo seccion, String tipo) {
        this.seccion = seccion;
        this.tipo = tipo;
    }

    public Unidad (CuerpoACuerpo seccion, Puntaje puntaje) {
        this.seccion = seccion;
        this.puntaje = puntaje;
    }

    public Unidad (String tipo, CuerpoACuerpo seccion, Puntaje puntaje) {
        this.seccion = seccion;
        this.tipo = tipo;
        this.puntaje = puntaje;
    }

    public Unidad() {
    }

    public int calcularPuntaje(int acumulador){
        return puntaje.calcularPuntaje(acumulador);
    }

    public void usar (Jugador jugador) {
        this.seccion.ubicar(this);
        this.seccion.actualizarValores();
    }

    public int esDeTipo (String tipo) {
        return tipo.equals(this.tipo) ? 1 : 0;
    }


    public void modificarPuntaje(String tipo, int acumulador) {
        if (this.tipo.equals(tipo)) {
            puntaje.modificarPuntaje(acumulador);
        }
    }

    public int devolverPuntajeSiSupera (int puntaje) {
        return this.puntaje.devolverPuntajeSiSupera(puntaje);
    }

    public boolean superaPuntaje (int puntaje) {
        return this.puntaje.superaPuntaje(puntaje);
    }

    public void ubicarEn(CuerpoACuerpo seccion) {
        seccion.ubicar(this);
    }


    protected int devolverPuntajeBase() {
        return puntaje.devolverPuntajeBase();
    }

    public void congelarPuntaje() {
        puntaje.congelarPuntaje();
    }

    public void duplicarPuntaje() {
        puntaje.duplicarPuntaje();
    }

    public void aumentarPuntaje() {
        puntaje.aumentarPuntaje();
    }
}
