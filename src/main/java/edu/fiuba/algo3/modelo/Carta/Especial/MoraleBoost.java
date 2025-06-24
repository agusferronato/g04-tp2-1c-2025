package edu.fiuba.algo3.modelo.Carta.Especial;

import edu.fiuba.algo3.modelo.Comando.ComandoMoraleBoost;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.Seccion;

public class MoraleBoost extends Especial {
    private Seccion seccion;

    public MoraleBoost(Seccion seccion) {
        this.seccion = seccion;
    }

    public void usar (Jugador jugador) {
        ComandoMoraleBoost comando = new ComandoMoraleBoost();
        seccion.agregarCartasA(comando);
        seccion.agregarComando(comando);
        seccion.actualizarValores();
    }

}
