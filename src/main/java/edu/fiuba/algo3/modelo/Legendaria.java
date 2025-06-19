package edu.fiuba.algo3.modelo;

public class Legendaria extends Unidad{
    private Unidad cartaBase;

    public Legendaria (Unidad carta) {
        this.cartaBase = carta;
    }

    public void usar (Jugador jugador) {
        jugador.jugarCarta(cartaBase);
    }

    public int calcularPuntaje(int acumulador) {
        return cartaBase.devolverPuntajeBase();
    }


    public void aumentarPuntaje() {}
    public void congelarPuntaje () {}
    public void duplicarPuntaje() {}


    public int esDeTipo (String tipo) {
        return 0;
    }

    public int devolverPuntajeSiSupera (int puntaje) {
        return puntaje;
    }

    public boolean superaPuntaje(int puntaje){
        return false;
    }


}
