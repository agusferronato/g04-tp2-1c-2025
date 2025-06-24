package edu.fiuba.algo3.modelo.Carta.Modificador;

import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;

public class Medico extends Modificador {

    public Medico(Unidad cartaBase) {
        super(cartaBase);
    }

    public void usar (Jugador jugador) {
        UnidadGeneral cartaRescatada = jugador.tomarDePilaDescarte();
        jugador.jugarCarta(cartaRescatada);
        cartaBase.ubicar();
    }
}