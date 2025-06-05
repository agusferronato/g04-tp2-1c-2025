package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombre;
    private Mazo mazo;

    public Jugador(String nombre, Mazo mazo) {
        this.nombre = nombre;
        this.mazo = mazo;
    }
    public int cantidad_cartas_mazo(){
        return mazo.cantidad_cartas();
    }
}
