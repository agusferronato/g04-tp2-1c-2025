package edu.fiuba.algo3.modelo;

public class Medico extends Unidad {
    private Unidad cartaBase;

    public Medico(Unidad cartaBase) {
        this.cartaBase = cartaBase;
    }

    public void usar (Jugador jugador) {
        Unidad cartaRescatada = jugador.tomarDePilaDescarte();
        jugador.jugarCarta(cartaRescatada);
        jugador.jugarCarta(this.cartaBase);
    }
}