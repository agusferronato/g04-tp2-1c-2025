package edu.fiuba.algo3.modelo.Carta.Especial;

import edu.fiuba.algo3.modelo.Comando.ComandoMoraleBoost;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.Seccion;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public class MoraleBoost extends Especial {
    private Seccion seccion;

    public MoraleBoost(Seccion seccion) {
        super(null);
        this.seccion = seccion;
    }

    public MoraleBoost(String nombre, String descripcion, Ubicable seccion) {
        super(nombre, descripcion);
        this.seccion = seccion;
    }

    public void usar (Jugador jugador) {
        ComandoMoraleBoost comando = new ComandoMoraleBoost();
        seccion.agregarCartasA(comando);
        seccion.agregarComando(comando);
        seccion.actualizarValores();
    }

    @Override
    public String getTipo () {
        return "Morale boost";
    }
}
