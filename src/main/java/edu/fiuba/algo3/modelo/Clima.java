package edu.fiuba.algo3.modelo;

public class Clima implements Carta {
    private Seccion seccion;

    public Clima(Seccion seccion) {
        this.seccion = seccion;
    }

    public void usar() {
        this.seccion.setStrategy(new CongelarPuntos());
        this.seccion.actualizarValores();
    }
}
