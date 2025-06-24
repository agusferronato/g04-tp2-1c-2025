package edu.fiuba.algo3.modelo.Carta;

import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;

public interface Carta {
    void usar(Jugador jugador);

    String getNombre();
}
