package edu.fiuba.algo3.modelo.Carta.Especial;

import edu.fiuba.algo3.modelo.Comando.ComandoCongelar;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.Seccion;

public class NeutralizarClima extends Especial {
    private Seccion seccion;

    public NeutralizarClima(Seccion seccion) {
        super(null);
        this.seccion = seccion;
    }

    @Override
    public void usar(Jugador jugador) {
        seccion.quitarComando(new ComandoCongelar());
        seccion.actualizarValores();
    }
}
