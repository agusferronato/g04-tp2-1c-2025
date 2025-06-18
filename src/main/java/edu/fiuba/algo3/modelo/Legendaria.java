package edu.fiuba.algo3.modelo;

public class Legendaria extends Unidad{
    private Unidad cartaBase;
    private CuerpoACuerpo seccion;

    public Legendaria (Unidad carta, CuerpoACuerpo seccion) {
        this.cartaBase = carta;
        this.seccion = seccion;
    }

    public void usar (Jugador jugador) {
        jugador.jugarCarta(cartaBase);
    }
    public int calcularPuntaje(int acumulador){
        return cartaBase.devolverPuntajeBase();
    }

    public void aumentarUnoEnElPuntaje(){}
    public void aplicarClima(){}
}
