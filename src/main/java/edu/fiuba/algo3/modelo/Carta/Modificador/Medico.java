package edu.fiuba.algo3.modelo.Carta.Modificador;

import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;

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