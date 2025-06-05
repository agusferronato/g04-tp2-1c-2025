package edu.fiuba.algo3.modelo;

import java.util.List;

public class Jugador {
    private String nombre;
    private List<Mazo> mazos;

    public Jugador() {

    }

    public Jugador(String nombre, List<Mazo> mazos) {
        this.nombre = nombre;
        this.mazos = mazos;
    }

    public Mazo seleccionarMazo () {
        return this.mazos.get(this.mazos.size()-1);
    }

    public Carta seleccionarCarta() {
        return new Unidad();
    }
}
