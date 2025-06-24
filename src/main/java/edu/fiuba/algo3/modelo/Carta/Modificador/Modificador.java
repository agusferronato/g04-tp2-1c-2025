package edu.fiuba.algo3.modelo.Carta.Modificador;

import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;

public abstract class Modificador extends UnidadGeneral {
    protected Unidad cartaBase;
    public Modificador(Unidad cartaBase) {
        this.cartaBase = cartaBase;
    }
    public abstract void usar(Jugador jugador);
}
