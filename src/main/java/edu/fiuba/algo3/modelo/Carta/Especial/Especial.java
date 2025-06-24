package edu.fiuba.algo3.modelo.Carta.Especial;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;

public abstract class Especial extends Carta {
    public Especial(String nombre) {
        super(nombre);
    }
    public abstract void usar(Jugador jugador);
    public String getNombre () { return ""; }
}
