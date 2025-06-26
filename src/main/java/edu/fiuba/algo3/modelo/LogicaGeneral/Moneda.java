package edu.fiuba.algo3.modelo.LogicaGeneral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Moneda {
    List<Jugador> jugadores;
    public Moneda (Jugador jugadorUno, Jugador jugadorDos) {
        jugadores = new ArrayList<>();
        jugadores.add(jugadorUno);
        jugadores.add(jugadorDos);
    }

    public Jugador jugadorInicial () {
        Collections.shuffle(jugadores);
        return jugadores.get(0);
    }
}
