package edu.fiuba.algo3.modelo;

import java.util.List;

public class Jugador {
    private String nombre;
    private List<Mazo> mazos;
    private int puntos;

    public Jugador() {

    }

    public Jugador(String nombre, List<Mazo> mazos) {
        this.nombre = nombre;
        this.mazos = mazos;
    }

    public Mazo seleccionarMazo () {
        return this.mazos.get(0);
    }

    public Carta seleccionarCarta() {
        return new Unidad();
    }

    public int actualizarPuntos(int sumar_puntos) {
        return this.puntos += sumar_puntos;
    }
}
