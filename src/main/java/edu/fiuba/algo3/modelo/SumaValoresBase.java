package edu.fiuba.algo3.modelo;

public class SumaValoresBase extends Unidad{
    private Unidad cartaBase;
    private Ubicable seccion;
    public SumaValoresBase(Unidad unidad, Ubicable seccion){
        cartaBase = unidad;
        this.seccion = seccion;
    }

    public void usar(Jugador jugador){
        jugador.jugarCarta(cartaBase);
        seccion.sumarUnoATodasLasCartas();
    }
}
