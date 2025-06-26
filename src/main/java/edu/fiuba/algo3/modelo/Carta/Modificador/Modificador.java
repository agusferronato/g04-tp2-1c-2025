package edu.fiuba.algo3.modelo.Carta.Modificador;

import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public abstract class Modificador extends UnidadGeneral {
    protected Unidad cartaBase;
    public Modificador(Unidad cartaBase) {
        this.cartaBase = cartaBase;
    }
    public abstract void usar(Jugador jugador);

    @Override
    public int calcularPuntaje(int acumulador){
        return cartaBase.calcularPuntaje(acumulador);
    }


    /* Metodo para test */
    @Override
    public String getNombre() {
        return cartaBase.getNombre();
    }

    /* Metodo para test */
    @Override
    public Ubicable getSeccion() {
        return cartaBase.getSeccion();
    }

}
