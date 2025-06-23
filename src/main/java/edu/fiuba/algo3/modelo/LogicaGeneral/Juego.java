package edu.fiuba.algo3.modelo.LogicaGeneral;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    private List<Jugador> jugadores;
    private Tablero tablero;

    public Juego (Tablero tablero) {
        this.jugadores = new ArrayList<>();
        this.tablero = tablero;
    }

    public void agregarJugador (Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public void pasarDeRonda () {
        for (Jugador jugador : this.jugadores) {
            jugador.descartarCartas();
        }
    }
}
