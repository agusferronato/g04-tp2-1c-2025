package edu.fiuba.algo3.modelo;

public abstract class ModificadorPuntos extends Especial{
    private Seccion seccion;

    public ModificadorPuntos(Seccion seccion) {
        this.seccion = seccion;
    }

    public void usar(Jugador jugador) {
        this.seccion.aplicarModificadorPuntos(this);
    }
    public abstract int aplicar(int puntaje);
}
