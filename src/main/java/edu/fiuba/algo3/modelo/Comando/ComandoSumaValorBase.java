package edu.fiuba.algo3.modelo.Comando;

import edu.fiuba.algo3.modelo.Carta.Puntaje;
import edu.fiuba.algo3.modelo.Carta.Unidad;

import java.util.List;

public class ComandoSumaValorBase extends ComandoPorCarta {
    @Override
    public void afectar(Puntaje puntaje) {
        puntaje.aumentarPuntaje();
    }
}
